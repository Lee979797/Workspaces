package com.ninemax.jpa.util;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import com.sun.media.jai.codec.ImageCodec;
import com.sun.media.jai.codec.ImageEncoder;
import com.sun.media.jai.codec.TIFFEncodeParam;
import org.apache.log4j.Logger;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.media.jai.JAI;
import javax.media.jai.RenderedOp;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.AreaAveragingScaleFilter;
import java.awt.image.BufferedImage;
import java.awt.image.FilteredImageSource;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 10-12-30
 * Time: 下午1:38
 */
public class ImageUtil {

    private static Logger log = Logger.getLogger(ImageUtil.class);
    private Component component = new Canvas();

    private BufferedImage bufferedImage;

    // 源文件路径
    private String srcPath;

    // 保存文件路径
    private String tagPath;

    public String getSrcPath() {
        return srcPath;
    }

    public void setSrcPath(String srcPath) {
        this.srcPath = srcPath;
    }

    public String getTagPath() {
        return tagPath;
    }

    public void setTagPath(String tagPath) {
        this.tagPath = tagPath;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    // 剪切点坐标
    private int x;

    private int y;

    // 剪切宽 高
    private int width;

    private int height;

    public ImageUtil() {
    }

    /**
     * 将若干个网上的tif,jpg图片合成一个个tif文件
     *
     * @param files Set<String>
     * @param os    OutputStream
     * @throws Exception
     */
    public static void margeTif(Set<String> files, ByteArrayOutputStream os) throws Exception {
        String urlName = UserPropertiesData.getValueByPropertyName("GSIP");
        List<RenderedOp> pages = new ArrayList<RenderedOp>();
        int i = 0;
        RenderedOp first = null;
        for (String f : files) {
            URL url = new URL(urlName + f);
            HttpURLConnection uc = (HttpURLConnection) url.openConnection();
            uc.connect();
            InputStream inputStream = uc.getInputStream();
            String[] fs = f.split("/");
            File file1 = new File(UserPropertiesData.getValueByPropertyName("tempPath") + "/" + fs[fs.length - 1]);
           OutputStream outputStream = new FileOutputStream(file1);
            byte[] bytes = new byte[1024];
            int c;
            while ((c = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, c);
            }
            outputStream.flush();
            RenderedOp page = JAI.create("fileload", file1.getCanonicalPath());
            if (i == 0) {
                first = page;

            } else {
                pages.add(page);
            }
            i++;

            uc.disconnect();
            outputStream.close();
        }
        if (first != null) {
            TIFFEncodeParam param = new TIFFEncodeParam();
            param.setCompression(TIFFEncodeParam.COMPRESSION_JPEG_TTN2);
            param.setExtraImages(pages.iterator());
            ImageEncoder encoder = ImageCodec.createImageEncoder("TIFF", os, param);
            encoder.encode(first);
            first.dispose();
        }
        for (i = 1; i < pages.size(); i++) {
            RenderedOp page = pages.get(i);
            page.dispose();
        }
        pages.clear();
        for (String f : files) {
            String[] fs = f.split("/");
            File file1 = new File(UserPropertiesData.getValueByPropertyName("tempPath") + "/" + fs[fs.length - 1]);
            file1.delete();
        }
    }

    public ImageUtil(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    // 裁剪图片并保存新图片
    public void cut(Boolean flag, String format) throws IOException {

        // 定义文件读取类 图片读取类
        FileInputStream fis = null;
        ImageInputStream iis = null;

        try {
            // 读取图片文件
            fis = new FileInputStream(srcPath);
            Image image = ImageIO.read(new File(srcPath));
            //原图片宽度
            int soureWidth = image.getWidth(null);
            if (flag) {
                //图片缩放比率
                double ratio = (double) soureWidth / 400;
                this.x = new Double(this.x * ratio).intValue();
                this.y = new Double(this.y * ratio).intValue();
                this.width = new Double(this.width * ratio).intValue();
                this.height = new Double(this.height * ratio).intValue();
            }

			/*
             * 返回包含所有当前已注册 ImageReader 的 Iterator，这些 ImageReader 声称能够解码指定格式。
			 * 参数：formatName - 包含非正式格式名称 .（例如 "jpeg" 或 "tiff"）等 。
			 */
            Iterator<ImageReader> it = ImageIO
                    .getImageReadersByFormatName(format);
            ImageReader reader = it.next();
            // 获取图片流
            iis = ImageIO.createImageInputStream(fis);
            /*
             * <p>iis:读取源.true:只向前搜索 </p>.将它标记为 ‘只向前搜索’。
			 * 此设置意味着包含在输入源中的图像将只按顺序读取，可能允许 reader 避免缓存包含与以前已经读取的图像关联的数据的那些输入部分。
			 */
            reader.setInput(iis, true);

			/*
             * <p>描述如何对流进行解码的类<p>.用于指定如何在输入时从 Java Image I/O
			 * 框架的上下文中的流转换一幅图像或一组图像。用于特定图像格式的插件 将从其 ImageReader 实现的
			 * getDefaultReadParam 方法中返回 ImageReadParam 的实例。
			 */
            ImageReadParam param = reader.getDefaultReadParam();
            /*
             * 图片裁剪区域。Rectangle 指定了坐标空间中的一个区域，通过 Rectangle 对象
			 * 的左上顶点的坐标（x，y）、宽度和高度可以定义这个区域。
			 */
            Rectangle rectangle = new Rectangle(x, y, width, height);
            // 提供一个 BufferedImage，将其用作解码像素数据的目标。
            param.setSourceRegion(rectangle);
            /*
             * 使用所提供的 ImageReadParam 读取通过索引 imageIndex 指定的对象，并将 它作为一个完整的
			 * BufferedImage 返回。
			 */
            BufferedImage bi = reader.read(0, param);
            // 保存新图片
            ImageIO.write(bi, format, new File(tagPath));
        } catch (IOException e) {
            log.error(e);
        } finally {
            if (fis != null)
                fis.close();
            if (iis != null)
                iis.close();
        }
    }

    /**
     * 旋转 - 参数指定目标图旋转角度。
     *
     * @param bufferedImage BufferedImage
     * @param radian        int 90 向右偏转90° 180 向右偏转180 270 向左偏转90
     * @return BufferedImage
     */
    public BufferedImage rotate(BufferedImage bufferedImage, int radian) {
        int width = bufferedImage.getWidth();
        int height = bufferedImage.getHeight();

        BufferedImage dstImage = null;
        AffineTransform affineTransform = new AffineTransform();

        if (radian == 180) {
            affineTransform.translate(width, height);
            dstImage = new BufferedImage(width, height, bufferedImage.getType());
        } else if (radian == 90) {
            affineTransform.translate(height, 0);
            dstImage = new BufferedImage(height, width, bufferedImage.getType());
        } else if (radian == 270) {
            affineTransform.translate(0, width);
            dstImage = new BufferedImage(height, width, bufferedImage.getType());
        }

        affineTransform.rotate(Math.toRadians(radian));
        AffineTransformOp affineTransformOp = new AffineTransformOp(
                affineTransform, null);

        return affineTransformOp.filter(bufferedImage, dstImage);
    }


    /**
     * 按比例进行放大缩小图像，zoomRatio = 1为原大，zoomRatio > 1为放大，zoomRatio < 1 为缩小
     *
     * @param fileName  源文件
     * @param zoomRatio 放大缩小比率
     * @return BufferedImage
     * @throws Exception exception
     */
    public BufferedImage createZoomSizeImage(String fileName, double zoomRatio) throws Exception {
        Image image = ImageIO.read(new File(fileName));
        int width = new Double(image.getWidth(null) * zoomRatio).intValue();
        int height = new Double(image.getHeight(null) * zoomRatio).intValue();
        AreaAveragingScaleFilter areaAveragingScaleFilter = new AreaAveragingScaleFilter(width, height);
        FilteredImageSource filteredImageSource = new FilteredImageSource(image.getSource(), areaAveragingScaleFilter);
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
        Graphics graphics = bufferedImage.createGraphics();
        graphics.drawImage(component.createImage(filteredImageSource), 0, 0, null);
        return bufferedImage;
    }


    /**
     * 按指定宽高压缩图片
     *
     * @param oldFile 原始文件
     * @param quality 高 中 低
     * @return boolean 压缩成功返回true 否则false
     */
    public boolean compress(String oldFile, float quality, String targetPath) {
        boolean flag = false;
        if (oldFile == null) {
            return flag;
        }
        String newImage;
        try {
            /** 对服务器上的临时文件进行处理 */
            Image srcFile = ImageIO.read(new File(oldFile));
            /** 宽,高设定 */
            BufferedImage tag = new BufferedImage(srcFile.getWidth(null),
                    srcFile.getHeight(null), BufferedImage.TYPE_INT_RGB);
            tag.getGraphics().drawImage(srcFile, 0, 0, srcFile.getWidth(null),
                    srcFile.getHeight(null), null);
            /** 压缩后的文件名 */
            newImage = targetPath;

            /** 压缩之后临时存放位置 */
            FileOutputStream out = new FileOutputStream(newImage);

            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
            JPEGEncodeParam jep = JPEGCodec.getDefaultJPEGEncodeParam(tag);
            /** 压缩质量 */
            jep.setQuality(quality, true);
            encoder.encode(tag, jep);

            out.close();
            srcFile.flush();
            flag = true;

        } catch (FileNotFoundException e) {
            log.error(e);
            flag = false;
        } catch (IOException e) {
            log.error(e);
            flag = false;
        }
        return flag;
    }


    /**
     * 图片格式转换
     *
     * @param source
     * @param result
     */
    public void convert(String source, String result) {
        try {
            File file = new File(source);
            Image img = ImageIO.read(file);
            BufferedImage tag = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_RGB);
            tag.getGraphics().drawImage(img.getScaledInstance(img.getWidth(null), img.getHeight(null), Image.SCALE_SMOOTH), 0, 0, null);
            FileOutputStream out = new FileOutputStream(result);
            // JPEGImageEncoder可适用于其他图片类型的转换
            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
            encoder.encode(tag);
            out.close();
        } catch (Exception e) {
            log.error(e);
            log.error("error", e);
        }
    }

    /**
     * 把图片印刷到图片上
     *
     * @param pressImg  --
     *                  水印文件
     * @param targetImg --
     *                  目标文件
     * @param newImg    --新图片
     * @param position  --位置
     * @param alpha     透明度
     */
    public boolean pressImage(String pressImg, String targetImg, String newImg, String position, float alpha) {
        boolean flag = false;
        try {
            //目标文件
            float Alpha = alpha;
            File _file = new File(targetImg);
            Image src = ImageIO.read(_file);
            int wideth = src.getWidth(null);
            int height = src.getHeight(null);
            BufferedImage image = new BufferedImage(wideth, height,
                    BufferedImage.TYPE_INT_RGB);
            Graphics2D g = image.createGraphics();
            g.drawImage(src, 0, 0, wideth, height, null);
            //水印文件
            File _filebiao = new File(pressImg);
            Image src_biao = ImageIO.read(_filebiao);
            int wideth_biao = src_biao.getWidth(null);
            int height_biao = src_biao.getHeight(null);
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, Alpha));
            //右下角
            if (position.equals("rb")) {
                g.drawImage(src_biao, (wideth - wideth_biao) / 1 - 10,
                        (height - height_biao) / 1 - 10, wideth_biao, height_biao, null);
                flag = true;
            }
            //右上角
            if (position.equals("rt")) {
                g.drawImage(src_biao, (wideth - wideth_biao) / 1 - 10, 10, wideth_biao, height_biao, null);
                flag = true;
            }
            //左下角
            if (position.equals("lb")) {
                g.drawImage(src_biao, 10,
                        (height - height_biao) / 1 - 10, wideth_biao, height_biao, null);
                flag = true;
            }
            //左上角
            if (position.equals("lt")) {
                g.drawImage(src_biao, 10, 10, wideth_biao, height_biao, null);
                flag = true;
            }
            //中间
            if (position.equals("m")) {
                g.drawImage(src_biao, (wideth - wideth_biao) / 2,
                        (height - height_biao) / 2, wideth_biao, height_biao, null);
                flag = true;
            }
            //水印文件结束
            g.dispose();
            FileOutputStream out = new FileOutputStream(newImg);
            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
            encoder.encode(image);
            out.close();
            return flag;
        } catch (Exception e) {
            log.error(e);
            return flag;
        }
    }

    /**
     * 打印文字水印图片
     *
     * @param pressText --文字
     * @param targetImg --
     *                  目标图片
     * @param newImg    产生新图片
     * @param fontName  --
     *                  字体名
     * @param fontStyle --
     *                  字体样式
     * @param color     --
     *                  字体颜色
     * @param fontSize  --
     *                  字体大小
     * @param position  --
     *                  偏移量
     */

    public boolean pressText(String pressText, String targetImg, String newImg,
                             String fontName, int fontStyle, int color, int fontSize, String position, float alpha) {
        boolean flag = false;
        try {
            float Alpha = alpha;
            File _file = new File(targetImg);
            Image src = ImageIO.read(_file);
            int wideth = src.getWidth(null);
            int height = src.getHeight(null);
            BufferedImage image = new BufferedImage(wideth, height,
                    BufferedImage.TYPE_INT_RGB);
            Graphics2D g = image.createGraphics();
            g.drawImage(src, 0, 0, wideth, height, null);
            g.setColor(Color.RED);
            g.setFont(new Font(fontName, fontStyle, fontSize));
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, Alpha));
            //右下角
            if (position.equals("rb")) {
                g.drawString(pressText, wideth - fontSize - pressText.length() * fontSize, height - fontSize / 2);
                flag = true;
            }
            //右上角
            if (position.equals("rt")) {
                g.drawString(pressText, wideth - fontSize - pressText.length() * fontSize, fontSize + 10);
                flag = true;
            }
            //左下角
            if (position.equals("lb")) {
                g.drawString(pressText, 10, height - fontSize / 2);
                flag = true;
            }
            //左上角
            if (position.equals("lt")) {
                g.drawString(pressText, 10, fontSize + 10);
                flag = true;
            }
            //中间
            if (position.equals("m")) {
                g.drawString(pressText, (wideth - pressText.length() * fontSize) / 2, height / 2 + fontSize / 2);
                flag = true;
            }
            g.dispose();
            FileOutputStream out = new FileOutputStream(newImg);
            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
            encoder.encode(image);
            out.close();
            return flag;
        } catch (Exception e) {
            log.error("error", e);
            log.error(e);
            return flag;
        }
    }


}
