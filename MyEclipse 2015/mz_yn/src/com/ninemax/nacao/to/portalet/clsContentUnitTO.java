/**
 * 栏目单元
 */
package com.ninemax.nacao.to.portalet;

/**
 * @author yonghedawang
 *
 */
public class clsContentUnitTO implements java.io.Serializable{

	
	private String unit_id; //栏目id
	private String unit_name; //栏目名称
	private String unit_title;//栏目标题
	private String unit_descript; //栏目描述
	private String unit_height; //栏目高度
	private String unit_url;//栏目的更多的连接url 替代列表模板
	private String unit_ico;//栏目的缩微图
	private String unit_initrow;//单元默认行位置
	private String unit_initcols;//单元默认列位置
	private String unit_isdetail;//是否有more页面
	private String unit_showrows;//默认的现实记录数
	private String unit_showcols;//要显示的字段名字
	private String unit_newico;//是否新图标
	private String unit_tablename; //　数据库表名
	private String unit_isShowJPG;//
	private String unit_showJPGPath;
	private String unit_isValid;//是否有效
	private String unit_isSysDefault;//是否系统默认栏目
	private String unit_operKind;//操作类型 0为通过编辑 1 通过数据库 2 为通过外部接口 3 通过类的自定义方法取数据 0通过编辑发布信息，即和信息发布向关联，取信息发布制定的且通过审核的数据
	private String item1;//内容信息表主键
	private String item2;//内容信息表详细页面
	private String status;//0running 1 delete
	private String orderByCol;
	private String formPage;//工作流转是表单页面
	
	//--周鹏鹏 Add
	private String sqlContent;//获取数据的sql语句
	private String unit_kind;//自定义的栏目类型
	private String dbSource;//如果是外部数据源的话，所连接的数据源
	private String unit_showcols_zh;//所要展示的数据字段的显示名称
	private String unit_all_columns;//要查询的所有列
	private String unit_all_columns_zh;//要查询的说有列的显示名称
	private String unit_extend_columns_en;//扩展的列名
	private String unit_extend_columns_zh;//扩展列的显示名称
	private String unit_sourceFile;
	private String unit_sourceImage;
	private String unit_sourceImage_link;
	private String left_template; 
	private String rightkey_id;//针对编辑类栏目和权限挂钩 以后便于删除对应的权限ID
	private String isRightkey;//是否系统加权
	
	private String webSite_id = "";//站点ID
	
	
	
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
