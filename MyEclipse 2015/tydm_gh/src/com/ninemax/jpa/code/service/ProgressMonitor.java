/* Licence:
*   Use this however/wherever you like, just don't blame me if it breaks anything.
*
* Credit:
*   If you're nice, you'll leave this bit:
*
*   Class by Pierre-Alexandre Losson -- http://www.telio.be/blog
*   email : plosson@users.sourceforge.net
*/
package com.ninemax.jpa.code.service;

import org.directwebremoting.WebContextFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by IntelliJ IDEA.
 * @author Original : plosson on 06-janv.-2006 12:19:08 - Last modified  by $Author: vde $ on $Date: 2004/11/26 22:43:57 $
 * @version 1.0 - Rev. $Revision: 1.2 $
 */
public class ProgressMonitor {
    public ProgressInfo progressInfo() {
        HttpServletRequest req = WebContextFactory.get().getHttpServletRequest();
        Object info = req.getSession().getAttribute("progressInfo");
        if (info == null)
            info = new ProgressInfo();
        return (ProgressInfo) info;
    }
}
