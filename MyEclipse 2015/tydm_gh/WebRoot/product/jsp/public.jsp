
<%//�û�������������

String gStrUserCode = "";		//�û�����
String gStrUserName = "";		//�û���ʵ����
String gStrUserType = "";	//�û�����()
String gStrOrgaCode = "";	//�û�������������
String gStrOrgaName="";      //�û�������������
String gStrBelongCode = "";		//
String gStrRoleCode = "";		//
String gStrUserLevel="";         //
String strThisPageTmp="";        //��һ������ҳ�� 
String gStrVisitFlag="";
String gStrBzjgLevel="";//��֤��������
String gStrBzjgQz="";//��֤����ǰ׺(���ݼ���ȡǰ2��4��6λ)
//���Ȩ�޺�������ĳһҳ���ܷ��ʵļ������û��ļ�����бȽϣ��粻������ܾ��û�����
//��ÿ������ҳ���е��ã����� strLevel ָ���ܷ���ҳ����û�����
gStrUserCode = (String)session.getAttribute("UserCode");
gStrUserCode="530000";
//�жϷ���Ȩ��
//���մ���� strThisPage
//Ҫ�󣺴�session��PemitModules
Vector gVecPemitModules=null;
gVecPemitModules=(Vector)session.getAttribute("PemitModules");



gStrUserName = (String)session.getAttribute("UserName");	//�û���ʵ����
gStrUserType = (String)session.getAttribute("UserType");	//�û�����
gStrBelongCode = (String)session.getAttribute("UserBelong");	//�û�����0ʡ�����ģ�1��֧����
gStrBelongCode = "530000";	//�û�����0ʡ�����ģ�1��֧����
gStrVisitFlag=(String)application.getAttribute("PermitVisit");
//�ж��Ƿ��Ѿ�������ϵͳ����ʱ��

//���û��������session��,�Ա�servlet����
session.setAttribute("UserLevel",gStrUserLevel.trim());
%>
