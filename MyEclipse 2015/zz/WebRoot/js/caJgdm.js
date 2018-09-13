    var CAPICOM_CURRENT_USER_STORE = 2;
    var CAPICOM_ENCODE_BASE64 = 0;
    var CAPICOM_INFO_SUBJECT_SIMPLE_NAME = 0;
    var CAPICOM_INFO_ISSUER_SIMPLE_NAME = 1;
    //var CAPICOM_INFO_SUBJECT_EMAIL_NAME = 2;
    //var CAPICOM_INFO_ISSUER_EMAIL_NAME  = 3;

    var CAPICOM_CERTIFICATE_FIND_ISSUER_NAME = 2;
    var CAPICOM_STORE_OPEN_READ_ONLY = 0

    //var CAPICOM_KEY_SPEC_KEYEXCHANGE= 1
    //var CAPICOM_KEY_SPEC_SIGNATURE = 2 	

    var CAPICOM_AUTHENTICATED_ATTRIBUTE_SIGNING_TIME = 0;
    var CAPICOM_E_CANCELLED = -2138568446;
    var CAPICOM_VERIFY_SIGNATURE_ONLY =0;
    var CAPICOM_VERIFY_SIGNATURE_AND_CERTIFICATE = 1;

    var CAPICOM_CERTIFICATE_FIND_TIME_VALID = 9;
    var CAPICOM_CERTIFICATE_FIND_SHA1_HASH = 0;
    var CAPICOM_CERTIFICATE_FIND_EXTENDED_PROPERTY = 6;
    var CERT_KEY_SPEC_PROP_ID = 6;
    var CAPICOM_CERTIFICATE_FIND_KEY_USAGE = 12;
    var CAPICOM_DIGITAL_SIGNATURE_KEY_USAGE = 0x00000080;
    var CAPICOM_DATA_ENCIPHERMENT_KEY_USAGE = 16;
    var CAPICOM_HASH_ALGORITHM_SHA1 = 0;
    var CAPICOM_CERTIFICATE_INCLUDE_CHAIN_EXCEPT_ROOT = 0;	
    var MyStore = new ActiveXObject("CAPICOM.Store");
    //Selected Certificate for signature
    var SelectedCertificate = new ActiveXObject("CAPICOM.Certificate");
    //Certificate selected check number,yes for 1,no for 0
    var CertificateSelectedCheck = 0;
    
    
    //通过证书指纹码获取证书的组织机构号数据
    function getCertCssId(cert) {
        var szResult = "";
        var isResult = true;

        var Certificates = getDigitalCert(cert);
        if (Certificates.Extensions() == null) {
            alert("获取扩展项客服信任号失败！");
        } else {
            for (var i = 1; i <= Certificates.Extensions().Count; i++) {
                //if (Certificates.Extensions(i).OID.Value == "1.2.86.11.7.11") {
                if (Certificates.Extensions(i).OID.Value == "1.2.156.10260.4.1.4") {
                    szTmp = Certificates.Extensions(i).EncodedData.Format(isResult);
                    var szTmps=szTmp.split(' ');

                    for (var j = 0; j <= szTmps.length; j++) {

                        if (szTmps[j] == "30") sTemp = "0";
                        else if (szTmps[j] == "31") sTemp = "1";
                        else if (szTmps[j] == "32") sTemp = "2";
                        else if (szTmps[j] == "33") sTemp = "3";
                        else if (szTmps[j] == "34") sTemp = "4";
                        else if (szTmps[j] == "35") sTemp = "5";
                        else if (szTmps[j] == "36") sTemp = "6";
                        else if (szTmps[j] == "37") sTemp = "7";
                        else if (szTmps[j] == "38") sTemp = "8";
                        else if (szTmps[j] == "39") sTemp = "9";
	
                        else if (szTmps[j] == "41") sTemp = "A";
                        else if (szTmps[j] == "42") sTemp = "B";
                        else if (szTmps[j] == "43") sTemp = "C";
                        else if (szTmps[j] == "44") sTemp = "D";
                        else if (szTmps[j] == "45") sTemp = "E";
                        else if (szTmps[j] == "46") sTemp = "F";
                        else if (szTmps[j] == "47") sTemp = "G";
                        else if (szTmps[j] == "48") sTemp = "H";
                        else if (szTmps[j] == "49") sTemp = "I";
                        else if (szTmps[j] == "4a") sTemp = "J";
                        else if (szTmps[j] == "4b") sTemp = "K";
                        else if (szTmps[j] == "4c") sTemp = "L";
                        else if (szTmps[j] == "4d") sTemp = "M";
                        else if (szTmps[j] == "4e") sTemp = "N";
                        else if (szTmps[j] == "4f") sTemp = "O";
                        else if (szTmps[j] == "50") sTemp = "P";
                        else if (szTmps[j] == "51") sTemp = "Q";
                        else if (szTmps[j] == "52") sTemp = "R";
                        else if (szTmps[j] == "53") sTemp = "S";
                        else if (szTmps[j] == "54") sTemp = "T";
                        else if (szTmps[j] == "55") sTemp = "U";
                        else if (szTmps[j] == "56") sTemp = "V";
                        else if (szTmps[j] == "57") sTemp = "W";
                        else if (szTmps[j] == "58") sTemp = "X";
                        else if (szTmps[j] == "59") sTemp = "Y";	
                        else if (szTmps[j] == "5a") sTemp = "Z";

                        else if (szTmps[j] == "61") sTemp = "a";
                        else if (szTmps[j] == "62") sTemp = "b";
                        else if (szTmps[j] == "63") sTemp = "c";
                        else if (szTmps[j] == "64") sTemp = "d";
                        else if (szTmps[j] == "65") sTemp = "e";
                        else if (szTmps[j] == "66") sTemp = "f";
                        else if (szTmps[j] == "67") sTemp = "g";
                        else if (szTmps[j] == "68") sTemp = "h";
                        else if (szTmps[j] == "69") sTemp = "i";
                        else if (szTmps[j] == "6a") sTemp = "j";
                        else if (szTmps[j] == "6b") sTemp = "k";
                        else if (szTmps[j] == "6c") sTemp = "l";
                        else if (szTmps[j] == "6d") sTemp = "m";
                        else if (szTmps[j] == "6e") sTemp = "n";
                        else if (szTmps[j] == "6f") sTemp = "o";
                        else if (szTmps[j] == "70") sTemp = "p";
                        else if (szTmps[j] == "71") sTemp = "q";
                        else if (szTmps[j] == "72") sTemp = "r";
                        else if (szTmps[j] == "73") sTemp = "s";
                        else if (szTmps[j] == "74") sTemp = "t";
                        else if (szTmps[j] == "75") sTemp = "u";
                        else if (szTmps[j] == "76") sTemp = "v";
                        else if (szTmps[j] == "77") sTemp = "w";
                        else if (szTmps[j] == "78") sTemp = "x";
                        else if (szTmps[j] == "79") sTemp = "y";	
                        else if (szTmps[j] == "7a") sTemp = "z";
                        
                       else sTemp = "";
                       szResult = szResult + sTemp;
                   }
                }
            }
            
            return szResult.replace(/[ ]/g, "");
            // Clean Up
            MyStore = null;
            FilteredCertificates = null;
        }
    }
    
    
    
    
    
    //通过证书指纹码获取签名证书
    				
    function getDigitalCert(cert) {
    		//通过证书下拉列表框选择  获取选择的证书指纹码数据，以下方法是通过证书指纹码数据获取用户选择的CA签名证书
        var szThumbprint=cert;//frmStore.txtCertificate.value;
        // instantiate the CAPICOM objects
        var MyStore = new ActiveXObject("CAPICOM.Store");

        // open the current users personal certificate store
        try {
            MyStore.Open(CAPICOM_CURRENT_USER_STORE, "My", CAPICOM_STORE_OPEN_READ_ONLY);
        }
        catch (e) {
            if (e.number != CAPICOM_E_CANCELLED) {
                alert("选择证书有问题，请确认USBkey正确插入!");
                return false;
            }
        }
        // find all of the certificates that have the specified hash
        var FilteredCertificates = MyStore.Certificates.Find(CAPICOM_CERTIFICATE_FIND_SHA1_HASH, szThumbprint);
        //alert(FilteredCertificates.Item(1));
        return FilteredCertificates.Item(1);//document.getElementById("datatext").value=FilteredCertificates.Item(1)
        // Clean Up
        MyStore = null;
        FilteredCertificates = null;
    }