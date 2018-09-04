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

/**
 * Created by IntelliJ IDEA.
 *
 * @author Original : plosson on 06-janv.-2006 12:19:14 - Last modified  by $Author: vde $ on $Date: 2004/11/26 22:43:57 $
 * @version 1.0 - Rev. $Revision: 1.2 $
 */
public class ProgressInfo {
    private long totalSize = 0;
    private long hasReads = 0;
    private long elapsedTime = 0;

    public ProgressInfo() {
    }

    public ProgressInfo(long totalSize, long hasReads, long elapsedTime) {
        this.totalSize = totalSize;
        this.hasReads = hasReads;
        this.elapsedTime = elapsedTime;
    }


    public long getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(long totalSize) {
        this.totalSize = totalSize;
    }

    public long gethasReads() {
        return hasReads;
    }

    public void sethasReads(long hasReads) {
        this.hasReads = hasReads;
    }

    public long getElapsedTime() {
        return elapsedTime;
    }

    public void setElapsedTime(long elapsedTime) {
        this.elapsedTime = elapsedTime;
    }

    public boolean isInProgress() {
        return hasReads < totalSize;
    }


    @Override
    public int hashCode() {
        return super.hashCode();
    }


    @Override
    public String toString() {
        return (this.hasReads) + ":" + this.totalSize;
    }
}
