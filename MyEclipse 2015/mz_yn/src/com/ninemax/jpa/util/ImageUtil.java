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
 * Time: ����1:38
 */
public class ImageUtil {

    private static Logger log = Logger.getLogger(ImageUtil.class);
    private Component component = new Canvas();

    private BufferedImage bufferedImage;

    // Դ�ļ�·��
    private String srcPath;

    // �����ļ�·��
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

    // ���е�����
    private int x;

    private int y;

    // ���п� ��
    private int width;

    private int height;

    public ImageUtil() {
    }

    /**
     * �����ɸ����ϵ�tif,jpgͼƬ�ϳ�һ����tif�ļ�
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

    // �ü�ͼƬ��������ͼƬ
    public void cut(Boolean flag, String format) throws IOException {

        // �����ļ���ȡ�� ͼƬ��ȡ��
        FileInputStream fis = null;
        ImageInputStream iis = null;

        try {
            // ��ȡͼƬ�ļ�
            fis = new FileInputStream(srcPath);
            Image image = ImageIO.read(new File(srcPath));
            //ԭͼƬ���
            int soureWidth = image.getWidth(null);
            if (flag) {
                //ͼƬ���ű���
                double ratio = (double) soureWidth / 400;
                this.x = new Double(this.x * ratio).intValue();
                this.y = new Double(this.y * ratio).intValue();
                this.width = new Double(this.width * ratio).intValue();
                this.height = new Double(this.height * ratio).intValue();
            }

			/*
             * ���ذ������е�ǰ��ע�� ImageReader �� Iterator����Щ ImageReader �����ܹ�����ָ����ʽ��
			 * ������formatName - ��������ʽ��ʽ���� .������ "jpeg" �� "tiff"���� ��
			 */
            Iterator<ImageReader> it = ImageIO
                    .getImageReadersByFormatName(format);
            ImageReader reader = it.next();
            // ��ȡͼƬ��
            iis = ImageIO.createImageInputStream(fis);
            /*
             * <p>iis:��ȡԴ.true:ֻ��ǰ���� </p>.�������Ϊ ��ֻ��ǰ��������
			 * ��������ζ�Ű���������Դ�е�ͼ��ֻ��˳���ȡ���������� reader ���⻺���������ǰ�Ѿ���ȡ��ͼ����������ݵ���Щ���벿�֡�
			 */
            reader.setInput(iis, true);

			/*
             * <p>������ζ������н������<p>.����ָ�����������ʱ�� Java Image I/O
			 * ��ܵ��������е���ת��һ��ͼ���һ��ͼ�������ض�ͼ���ʽ�Ĳ�� ������ ImageReader ʵ�ֵ�
			 * getDefaultReadParam �����з��� ImageReadParam ��ʵ����
			 */
            ImageReadParam param = reader.getDefaultReadParam();
            /*
             * ͼƬ�ü�����Rectangle ָ��������ռ��е�һ������ͨ�� Rectangle ����
			 * �����϶�������꣨x��y������Ⱥ͸߶ȿ��Զ����������
			 */
            Rectangle rectangle = new Rectangle(x, y, width, height);
            // �ṩһ�� BufferedImage���������������������ݵ�Ŀ�ꡣ
            param.setSourceRegion(rectangle);
            /*
             * ʹ�����ṩ�� ImageReadParam ��ȡͨ������ imageIndex ָ���Ķ��󣬲��� ����Ϊһ��������
			 * BufferedImage ���ء�
			 */
            BufferedImage bi = reader.read(0, param);
            // ������ͼƬ
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
     * ��ת - ����ָ��Ŀ��ͼ��ת�Ƕȡ�
     *
     * @param bufferedImage BufferedImage
     * @param radian        int 90 ����ƫת90�� 180 ����ƫת180 270 ����ƫת90
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
     * ���������зŴ���Сͼ��zoomRatio = 1Ϊԭ��zoomRatio > 1Ϊ�Ŵ�zoomRatio < 1 Ϊ��С
     *
     * @param fileName  Դ�ļ�
     * @param zoomRatio �Ŵ���С����
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
     * ��ָ�����ѹ��ͼƬ
     *
     * @param oldFile ԭʼ�ļ�
     * @param quality �� �� ��
     * @return boolean ѹ���ɹ�����true ����false
     */
    public boolean compress(String oldFile, float quality, String targetPath) {
        boolean flag = false;
        if (oldFile == null) {
            return flag;
        }
        String newImage;
        try {
            /** �Է������ϵ���ʱ�ļ����д��� */
            Image srcFile = ImageIO.read(new File(oldFile));
            /** ��,���趨 */
            BufferedImage tag = new BufferedImage(srcFile.getWidth(null),
                    srcFile.getHeight(null), BufferedImage.TYPE_INT_RGB);
            tag.getGraphics().drawImage(srcFile, 0, 0, srcFile.getWidth(null),
                    srcFile.getHeight(null), null);
            /** ѹ������ļ��� */
            newImage = targetPath;

            /** ѹ��֮����ʱ���λ�� */
            FileOutputStream out = new FileOutputStream(newImage);

            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
            JPEGEncodeParam jep = JPEGCodec.getDefaultJPEGEncodeParam(tag);
            /** ѹ������ */
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
     * ͼƬ��ʽת��
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
            // JPEGImageEncoder������������ͼƬ���͵�ת��
            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
            encoder.encode(tag);
            out.close();
        } catch (Exception e) {
            log.error(e);
            log.error("error", e);
        }
    }

    /**
     * ��ͼƬӡˢ��ͼƬ��
     *
     * @param pressImg  --
     *                  ˮӡ�ļ�
     * @param targetImg --
     *                  Ŀ���ļ�
     * @param newImg    --��ͼƬ
     * @param position  --λ��
     * @param alpha     ͸����
     */
    public boolean pressImage(String pressImg, String targetImg, String newImg, String position, float alpha) {
        boolean flag = false;
        try {
            //Ŀ���ļ�
            float Alpha = alpha;
            File _file = new File(targetImg);
            Image src = ImageIO.read(_file);
            int wideth = src.getWidth(null);
            int height = src.getHeight(null);
            BufferedImage image = new BufferedImage(wideth, height,
                    BufferedImage.TYPE_INT_RGB);
            Graphics2D g = image.createGraphics();
            g.drawImage(src, 0, 0, wideth, height, null);
            //ˮӡ�ļ�
            File _filebiao = new File(pressImg);
            Image src_biao = ImageIO.read(_filebiao);
            int wideth_biao = src_biao.getWidth(null);
            int height_biao = src_biao.getHeight(null);
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, Alpha));
            //���½�
            if (position.equals("rb")) {
                g.drawImage(src_biao, (wideth - wideth_biao) / 1 - 10,
                        (height - height_biao) / 1 - 10, wideth_biao, height_biao, null);
                flag = true;
            }
            //���Ͻ�
            if (position.equals("rt")) {
                g.drawImage(src_biao, (wideth - wideth_biao) / 1 - 10, 10, wideth_biao, height_biao, null);
                flag = true;
            }
            //���½�
            if (position.equals("lb")) {
                g.drawImage(src_biao, 10,
                        (height - height_biao) / 1 - 10, wideth_biao, height_biao, null);
                flag = true;
            }
            //���Ͻ�
            if (position.equals("lt")) {
                g.drawImage(src_biao, 10, 10, wideth_biao, height_biao, null);
                flag = true;
            }
            //�м�
            if (position.equals("m")) {
                g.drawImage(src_biao, (wideth - wideth_biao) / 2,
                        (height - height_biao) / 2, wideth_biao, height_biao, null);
                flag = true;
            }
            //ˮӡ�ļ�����
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
     * ��ӡ����ˮӡͼƬ
     *
     * @param pressText --����
     * @param targetImg --
     *                  Ŀ��ͼƬ
     * @param newImg    ������ͼƬ
     * @param fontName  --
     *                  ������
     * @param fontStyle --
     *                  ������ʽ
     * @param color     --
     *                  ������ɫ
     * @param fontSize  --
     *                  �����С
     * @param position  --
     *                  ƫ����
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
            //���½�
            if (position.equals("rb")) {
                g.drawString(pressText, wideth - fontSize - pressText.length() * fontSize, height - fontSize / 2);
                flag = true;
            }
            //���Ͻ�
            if (position.equals("rt")) {
                g.drawString(pressText, wideth - fontSize - pressText.length() * fontSize, fontSize + 10);
                flag = true;
            }
            //���½�
            if (position.equals("lb")) {
                g.drawString(pressText, 10, height - fontSize / 2);
                flag = true;
            }
            //���Ͻ�
            if (position.equals("lt")) {
                g.drawString(pressText, 10, fontSize + 10);
                flag = true;
            }
            //�м�
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
