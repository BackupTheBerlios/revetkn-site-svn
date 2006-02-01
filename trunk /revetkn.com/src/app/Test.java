import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revetkn.site.model.service.flickr.FlickrWebImageService;

/**
 * Copyright (c) 2006 Mark Allen [mark.a.allen@gmail.com]
 *
 * Permission is hereby granted, free of charge, to any person obtaining a
 * copy of this software and associated documentation files (the "Software"), 
 * to deal in the Software without restriction, including without limitation
 * the rights to use, copy, modify, merge, publish, distribute, sublicense,
 * and/or sell copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 */

/**
 * @author <a href="mailto:mark.a.allen@gmail.com">Mark Allen</a>
 * @version $Id$ $Rev$ $Revision$
 * @since 0.1
 */
public class Test
{
    public static void main(String args[])
    {
        ClassPathXmlApplicationContext ctx = null;
  
        try
        {
            /*  
            ctx = new ClassPathXmlApplicationContext(new String[] { "spring/util.xml",
                    "spring/service.xml", "spring/webmvc.xml", "spring/data.xml" });
                    */

            FlickrWebImageService imageService = new FlickrWebImageService();

            System.out
                    .println(imageService
                            .findImages("http://www.flickr.com/services/feeds/photos_public.gne?id=18483805@N00&format=rss_200"));

        }
        finally
        {
            if (ctx != null)
            {
                ctx.close();
            }
        }

    }
}
