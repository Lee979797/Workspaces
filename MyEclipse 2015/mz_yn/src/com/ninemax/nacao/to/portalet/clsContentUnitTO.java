/**
 * ��Ŀ��Ԫ
 */
package com.ninemax.nacao.to.portalet;

/**
 * @author yonghedawang
 *
 */
public class clsContentUnitTO implements java.io.Serializable{

	
	private String unit_id; //��Ŀid
	private String unit_name; //��Ŀ����
	private String unit_title;//��Ŀ����
	private String unit_descript; //��Ŀ����
	private String unit_height; //��Ŀ�߶�
	private String unit_url;//��Ŀ�ĸ��������url ����б�ģ��
	private String unit_ico;//��Ŀ����΢ͼ
	private String unit_initrow;//��ԪĬ����λ��
	private String unit_initcols;//��ԪĬ����λ��
	private String unit_isdetail;//�Ƿ���moreҳ��
	private String unit_showrows;//Ĭ�ϵ���ʵ��¼��
	private String unit_showcols;//Ҫ��ʾ���ֶ�����
	private String unit_newico;//�Ƿ���ͼ��
	private String unit_tablename; //�����ݿ����
	private String unit_isShowJPG;//
	private String unit_showJPGPath;
	private String unit_isValid;//�Ƿ���Ч
	private String unit_isSysDefault;//�Ƿ�ϵͳĬ����Ŀ
	private String unit_operKind;//�������� 0Ϊͨ���༭ 1 ͨ�����ݿ� 2 Ϊͨ���ⲿ�ӿ� 3 ͨ������Զ��巽��ȡ���� 0ͨ���༭������Ϣ��������Ϣ�����������ȡ��Ϣ�����ƶ�����ͨ����˵�����
	private String item1;//������Ϣ������
	private String item2;//������Ϣ����ϸҳ��
	private String status;//0running 1 delete
	private String orderByCol;
	private String formPage;//������ת�Ǳ�ҳ��
	
	//--������ Add
	private String sqlContent;//��ȡ���ݵ�sql���
	private String unit_kind;//�Զ������Ŀ����
	private String dbSource;//������ⲿ����Դ�Ļ��������ӵ�����Դ
	private String unit_showcols_zh;//��Ҫչʾ�������ֶε���ʾ����
	private String unit_all_columns;//Ҫ��ѯ��������
	private String unit_all_columns_zh;//Ҫ��ѯ��˵���е���ʾ����
	private String unit_extend_columns_en;//��չ������
	private String unit_extend_columns_zh;//��չ�е���ʾ����
	private String unit_sourceFile;
	private String unit_sourceImage;
	private String unit_sourceImage_link;
	private String left_template; 
	private String rightkey_id;//��Ա༭����Ŀ��Ȩ�޹ҹ� �Ժ����ɾ����Ӧ��Ȩ��ID
	private String isRightkey;//�Ƿ�ϵͳ��Ȩ
	
	private String webSite_id = "";//վ��ID
	
	
	
	public String getWebSite_id() {
		return webSite_id;
	}
	public void setWebSite_id(String webSite_id) {
		this.webSite_id = webSite_id;
	}
	public String getIsRightkey() {
		return isRightkey;
	}
	public void setIsRightkey(String isRightkey) {
		this.isRightkey = isRightkey;
	}
	public String getRightkey_id() {
		return rightkey_id;
	}
	public void setRightkey_id(String rightkey_id) {
		this.rightkey_id = rightkey_id;
	}
	public String getLeft_template() {
		return left_template;
	}
	public void setLeft_template(String left_template) {
		this.left_template = left_template;
	}
	public String getUnit_sourceFile() {
		return unit_sourceFile;
	}
	public void setUnit_sourceFile(String unit_sourceFile) {
		this.unit_sourceFile = unit_sourceFile;
	}
	public String getUnit_sourceImage() {
		return unit_sourceImage;
	}
	public void setUnit_sourceImage(String unit_sourceImage) {
		this.unit_sourceImage = unit_sourceImage;
	}
	public String getUnit_sourceImage_link() {
		return unit_sourceImage_link;
	}
	public void setUnit_sourceImage_link(String unit_sourceImage_link) {
		this.unit_sourceImage_link = unit_sourceImage_link;
	}
	
	public String getUnit_all_columns() {
		return unit_all_columns;
	}
	public void setUnit_all_columns(String unit_all_columns) {
		this.unit_all_columns = unit_all_columns;
	}
	public String getUnit_all_columns_zh() {
		return unit_all_columns_zh;
	}
	public void setUnit_all_columns_zh(String unit_all_columns_zh) {
		this.unit_all_columns_zh = unit_all_columns_zh;
	}
	public String getUnit_extend_columns_en() {
		return unit_extend_columns_en;
	}
	public void setUnit_extend_columns_en(String unit_extend_columns_en) {
		this.unit_extend_columns_en = unit_extend_columns_en;
	}
	public String getUnit_extend_columns_zh() {
		return unit_extend_columns_zh;
	}
	public void setUnit_extend_columns_zh(String unit_extend_columns_zh) {
		this.unit_extend_columns_zh = unit_extend_columns_zh;
	}
	public String getUnit_showcols_zh() {
		return unit_showcols_zh;
	}
	public void setUnit_showcols_zh(String unit_showcols_zh) {
		this.unit_showcols_zh = unit_showcols_zh;
	}
	public String getDbSource() {
		return dbSource;
	}
	public void setDbSource(String dbSource) {
		this.dbSource = dbSource;
	}
	public String getSqlContent() {
		return sqlContent;
	}
	public void setSqlContent(String sqlContent) {
		this.sqlContent = sqlContent;
	}
	public String getUnit_kind() {
		return unit_kind;
	}
	public void setUnit_kind(String unit_kind) {
		this.unit_kind = unit_kind;
	}
	public String getItem1() {
		return item1;
	}
	public void setItem1(String item1) {
		this.item1 = item1;
	}
	public String getItem2() {
		return item2;
	}
	public void setItem2(String item2) {
		this.item2 = item2;
	}
	public String getUnit_descript() {
		return unit_descript;
	}
	public void setUnit_descript(String unit_descript) {
		this.unit_descript = unit_descript;
	}
	public String getUnit_height() {
		return unit_height;
	}
	public void setUnit_height(String unit_height) {
		this.unit_height = unit_height;
	}
	public String getUnit_ico() {
		return unit_ico;
	}
	public void setUnit_ico(String unit_ico) {
		this.unit_ico = unit_ico;
	}
	public String getUnit_id() {
		return unit_id;
	}
	public void setUnit_id(String unit_id) {
		this.unit_id = unit_id;
	}
	public String getUnit_initcols() {
		return unit_initcols;
	}
	public void setUnit_initcols(String unit_initcols) {
		this.unit_initcols = unit_initcols;
	}
	public String getUnit_initrow() {
		return unit_initrow;
	}
	public void setUnit_initrow(String unit_initrow) {
		this.unit_initrow = unit_initrow;
	}
	public String getUnit_isdetail() {
		return unit_isdetail;
	}
	public void setUnit_isdetail(String unit_isdetail) {
		this.unit_isdetail = unit_isdetail;
	}
	public String getUnit_isShowJPG() {
		return unit_isShowJPG;
	}
	public void setUnit_isShowJPG(String unit_isShowJPG) {
		this.unit_isShowJPG = unit_isShowJPG;
	}
	public String getUnit_isSysDefault() {
		return unit_isSysDefault;
	}
	public void setUnit_isSysDefault(String unit_isSysDefault) {
		this.unit_isSysDefault = unit_isSysDefault;
	}
	public String getUnit_isValid() {
		return unit_isValid;
	}
	public void setUnit_isValid(String unit_isValid) {
		this.unit_isValid = unit_isValid;
	}
	public String getUnit_name() {
		return unit_name;
	}
	public void setUnit_name(String unit_name) {
		this.unit_name = unit_name;
	}
	public String getUnit_newico() {
		return unit_newico;
	}
	public void setUnit_newico(String unit_newico) {
		this.unit_newico = unit_newico;
	}
	public String getUnit_operKind() {
		return unit_operKind;
	}
	public void setUnit_operKind(String unit_operKind) {
		this.unit_operKind = unit_operKind;
	}
	public String getUnit_showcols() {
		return unit_showcols;
	}
	public void setUnit_showcols(String unit_showcols) {
		this.unit_showcols = unit_showcols;
	}
	public String getUnit_showJPGPath() {
		return unit_showJPGPath;
	}
	public void setUnit_showJPGPath(String unit_showJPGPath) {
		this.unit_showJPGPath = unit_showJPGPath;
	}
	public String getUnit_showrows() {
		return unit_showrows;
	}
	public void setUnit_showrows(String unit_showrows) {
		this.unit_showrows = unit_showrows;
	}
	public String getUnit_tablename() {
		return unit_tablename;
	}
	public void setUnit_tablename(String unit_tablename) {
		this.unit_tablename = unit_tablename;
	}
	public String getUnit_title() {
		return unit_title;
	}
	public void setUnit_title(String unit_title) {
		this.unit_title = unit_title;
	}
	public String getUnit_url() {
		return unit_url;
	}
	public void setUnit_url(String unit_url) {
		this.unit_url = unit_url;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getOrderByCol() {
		return orderByCol;
	}
	public void setOrderByCol(String orderByCol) {
		this.orderByCol = orderByCol;
	}
	
	public String getFormPage() {
		return formPage;
	}
	public void setFormPage(String formPage) {
		this.formPage = formPage;
	}
	
	
	
	
}
