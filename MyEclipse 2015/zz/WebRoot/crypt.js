//ȫ�ֱ���
var serverPacket="";  	//�������ش����ݰ�
var clientAuthCode="";	//�ͻ�����֤��
var serverRandom="";    //�������ش��������
var operType="";      	//��������
var userId="";        	//�û�ID
var userPasswd = "";// �û�����
var deviceType = "";	//�豸����
var devicePort = "";	//�豸�˿ں�
var userName="";     //�û�����
var clientPubKey=""; //�ͻ��˹�Կ
var sysName="";      //��ϵͳ����
var sysCode="";      //��ϵͳ����
var userAccount="";  //�û���¼��ϵͳ���ʺ�
var userPin="";      //�û���¼��ϵͳ������

var nProvType   = 1;//�����豸���͵Ŀ���ѡ��


// �����û����豸��ѡ��
function setDeviceParam(userPin)
{
    if (CryptCtrl.IsDeviceOpened()!= 0)
    {
    	CryptCtrl.CloseDevice();
    }
    CryptCtrl.strContainer = "";

    userPasswd = userPin;
}

//���豸
//type= 0: ��RSAӦ�á�
//type= 1: ��SM2Ӧ�á�
function openDeviceEx(type, userPin)
{
   	var err = 0;

    setDeviceParam(userPin);
    
    if (CryptCtrl.IsDeviceOpened()!= 0)
    {
    	CryptCtrl.CloseDevice();
    }
	
    var containerName;
	if (type == 0)
	{
		containerName = "//ECCARSA1/ECCARSA1CONTAINER";
	}
	else if (type == 1)
	{
		containerName = "//ECCASM2/ECCASM2CONTAINER";
	}
	else
	{
		return -1; //ERROR.
	}
    CryptCtrl.OpenDevice(0, containerName, 0, userPasswd);
  
    if (CryptCtrl.ErrCode != 0 && CryptCtrl.ErrCode != -1)
    {
    	alert(CryptCtrl.ErrMsg);
    }

    devicePort=CryptCtrl.strContainer;

    return CryptCtrl.ErrCode;
}

//���豸
function openDevice(userPin)
{
   	var err = 0;

    setDeviceParam(userPin);
    
    if (CryptCtrl.IsDeviceOpened()!= 0)
    {
    	CryptCtrl.CloseDevice();
    }
    
   CryptCtrl.OpenDeviceEx(userPasswd) ;
  
    if(CryptCtrl.ErrCode==0x57)
    {
        CryptCtrl.OpenDeviceEx(userPasswd);
    }
    
    if (CryptCtrl.ErrCode != 0 && CryptCtrl.ErrCode != -1)
    {
    	alert(CryptCtrl.ErrMsg);
    }

    devicePort=CryptCtrl.strContainer;

    return CryptCtrl.ErrCode;
}

//�����ͻ������ݰ�ClientHello
function MakeClientHello()
{
    //ֻҪ���Ǵ��ⵥ����֤,����Ҫ������֤��
    var vbNullString="";
    var dwFlag=0;
   	
   	CryptCtrl.ClientHello(dwFlag);
   	if(CryptCtrl.ErrCode != 0)
    {
    	alert( CryptCtrl.ErrMsg);
    }

   	return CryptCtrl.ErrCode;
}

//��֤�������˵�serverHello���ݰ��������ɿͻ�����֤��
function MakeClientAuthCode()
{
  	var err = 0;
  	//err = openDevice();

  	//if (err != 0) return err;
    //�ͻ�����֤ServerHello

   	CryptCtrl.ClientAuth(serverPacket);

   	if (CryptCtrl.ErrCode != 0)
   	{
    	alert(CryptCtrl.ErrMsg);
    	return CryptCtrl.ErrCode;
   	}
   	clientAuthCode = CryptCtrl.strResult;
    //�����ͻ�����֤��󣬹رտͻ���
   // CryptCtrl.CloseDevice();
    //userId = CryptCtrl.strUserId;
    return CryptCtrl.ErrCode;
}

//�޸��û�����
function changePin()
{
   if(openDevice()==0)
   {
        CryptCtrl.ChangePinEx();
        alert(CryptCtrl.ErrMsg);
   }
}

//�����ݽ�������ǩ��
function signData(strData,signTime,flag)
{
	var err = 0;
	//�򿪿ͻ����豸����ʹ�ÿͻ����豸ǰ����ִ�д��豸����
	err = openDevice();
	if (err != 0) return err;
	//����ǩ������
	CryptCtrl.SignData(strData,strData.length,"SHA1withRSA",signTime,flag);
	if(CryptCtrl.ErrCode != 0)
	{
		alert(CryptCtrl.ErrMsg);
		return CryptCtrl.ErrCode;
	}

	//ǩ�����
	strSignedCode = CryptCtrl.strResult;
	//�ر��豸����
	CryptCtrl.CloseDevice();
	return CryptCtrl.ErrCode;
}

