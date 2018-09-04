/* Licence:
 *   Use this however/wherever you like, just don't blame me if it breaks anything.
 *
 * Credit:
 *   If you're nice, you'll leave this bit:
 *
 *   Class by Pierre-Alexandre Losson -- http://www.telio.be/blog
 *   email : plosson@users.sourceforge.net
 */
var taltol = 100;
var now = 0;
var progressPercent = 0;
function refreshProgress() {
    dwr.engine.setAsync(false);
    monitor.progressInfo(function (data) {
        if (data.inProgress) {
            progressPercent = Math.ceil((data.hasReads / data.totalSize) * 100);
            $("#progressbar").progressBar(progressPercent);
            window.setTimeout(refreshProgress, 100);
        } else {
            progressPercent = Math.ceil((now / taltol) * 100);
            if (now < taltol)
                now += 10;
            else {
                now = 0;
            }
            $("#progressbar").progressBar(progressPercent);
            window.setTimeout(refreshProgress, 100);
        }
    });
}
function closeWin() {
    $("#progressbar").fadeOut(100);
    window.parent.ymPrompt.close();
}
function progress() {
    $("#progressbar").fadeIn();
    window.setTimeout(refreshProgress, 1000);
}
$(document).ready(function () {
    $("#progressbar").progressBar();
});
