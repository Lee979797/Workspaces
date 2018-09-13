<%@ page contentType="text/html;charset=GB18030"%>
<%@ page import="isc.authclt.IscJcrypt"%>
<%@ page import="isc.property.IscProperties"%>
<%@ page import="isc.log.IscLog"%>
<%@ page import="isc.log.IscLog"%>
<%@ page import="java.io.ByteArrayInputStream"%>
<%@ page import="org.bouncycastle.util.encoders.Hex"%>
<%@ page import="org.bouncycastle.asn1.ASN1InputStream"%>
<%@ page import="org.bouncycastle.asn1.ASN1Sequence"%>
<%@ page import="org.bouncycastle.asn1.x509.TBSCertificate"%>
<%@ page import="org.bouncycastle.asn1.x509.Certificate"%>
<%@ page import="org.bouncycastle.asn1.x500.RDN"%>
<%@ page import="org.bouncycastle.asn1.x500.style.BCStyle"%>

<%
	try {
		IscJcrypt Japi = new IscJcrypt();

		//从配置文件中获取加密设备的属性
		IscProperties prop = new IscProperties();
		String srvProvider = prop.iscGetProperty("strProvider",
				"authclt");
		String srvContainer = prop.iscGetProperty("strContainer",
				"Slot1");
		int srvProvType = Integer.parseInt(
				prop.iscGetProperty("strProvType", "604"), 16);
		String strPwd = prop.iscGetProperty("password", "88880001");

		String type = request.getParameter("type");

		if (type.equals("CLIENT-HELLO")) {

			String clientHello = request.getParameter("clientHello");
			//System.out.println("clientHello:"+clientHello);

			int err = Japi.openDevice(srvContainer, srvProvider,
					srvProvType, strPwd);
			if (err != 0) {
				out.print("-1::" + Japi.errMsg);
				Japi.closeDevice();
				return;
			}

			// 验证客户端数据包,并产生服务器端数据包
			String random = Japi.serverHello(clientHello);
			if (random.length() == 0) {
				System.out.println("clientHello" + clientHello);
				System.out.println("Japi.errMsg" + Japi.errMsg);
				out.print("-1::" + Japi.errMsg);
				Japi.closeDevice();
				return;
			}

			Japi.closeDevice();
			//System.out.println("Japi.strResult:"+Japi.strResult);
			//System.out.println("random:"+random);

			//System.out.println("random length:"+random.length());

			out.print("0::" + Japi.strResult + "::" + random);
			return;
		} else if (type.equals("CLIENT-AUTHCODE")) {

			String clientAuthCode = request
					.getParameter("clientAuthCode");
			String serverRandom = request.getParameter("serverRandom");
			//System.out.println("clientAuthCode:"+clientAuthCode);
			//System.out.println("serverRandom:"+serverRandom);

			int err = Japi.openDevice(srvContainer, srvProvider,
					srvProvType, strPwd);
			if (err != 0) {
				out.print("-1::" + Japi.errMsg);
				Japi.closeDevice();
				return;
			}

			//验证客户端认证码
			err = Japi.serverAuth(clientAuthCode, serverRandom.trim());
			if (err != 0) {
				out.print("-1::" + Japi.errMsg);
				Japi.closeDevice();
				return;
			}

			//关闭设备
			err = Japi.closeDevice();

			//获取用户证书序列号,并把它放到Session中，以备在应用系统中使用
			String strCert = Japi.strResult;
			byte[] csCert = Hex.decode(strCert);
			ByteArrayInputStream bIn = new ByteArrayInputStream(csCert);
			ASN1InputStream aIn = new ASN1InputStream(bIn);
			ASN1Sequence seq = (ASN1Sequence) aIn.readObject();

			Certificate obj = Certificate.getInstance(seq);
			TBSCertificate tbsCert = obj.getTBSCertificate();

			String sn = tbsCert.getSerialNumber().getValue()
					.toString(16);
			session.setAttribute("SN", sn);

			//取组织机构代码证号      	
			RDN rdnCN = tbsCert.getSubject().getRDNs(BCStyle.CN)[0];
			String userName = rdnCN.getFirst().getValue().toString();
			session.setAttribute("jgdm", userName);

			//取组织机构代码名称
			RDN rdnOrgName = tbsCert.getSubject().getRDNs(BCStyle.OU)[0];
			String orgName = rdnOrgName.getFirst().getValue()
					.toString();
			session.setAttribute("OrgName", orgName);

			//身份认证成功标志
			session.setAttribute("success", "true");

			out.print("0::success");
			return;
		} else {
			out.print("-1::错误的请求类型");
			return;
		}
	} catch (Exception e) {
		e.printStackTrace();
		out.print("-1::" + e.getMessage());
	}
%>