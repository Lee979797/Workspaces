//验证机构代码的有效性
function verifyCode(AOrgCode){//d1231232 1
	AOrgCode = AOrgCode.toUpperCase();
	var C = ['0','1','2','3','4','5','6','7','8','9',
             'A','B','C','D','E','F','G','H','I',
             'J','K','L','M','N','O','P','Q','R',
             'S','T','U','V','W','X','Y','Z'],
        V = [0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,
            19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35],
        W = [3,7,9,10,5,8,4,2],
        A = ['1','2','3','4','5','6','7','8','9','X','0'];
	
	var Clength= C.length;
	var len = AOrgCode.length;
	var result;
	if(len != 9){
		return false;
	}
	function getIndex(Achar){
		for(var tmp= 0;tmp< Clength;tmp++){
			if(C[tmp] == Achar){
				result = tmp;
				return result;
			}
		}
	}
	var s=0 ,j=0;
	for(var i= 0;i < 8;i++){
		getIndex(AOrgCode.charAt(i));
		j= V[result]*W[i];alert("V*W: "+V[result]+"*"+W[i]);
		s+=j;
	}
	s = 10-(s%11);
	alert("A[s] "+A[s]);//此为最后一位数值
	//return A[s];
	if(A[s]==AOrgCode.charAt(8)){
		return true;
	}else{
		return false;
	}
}

//验证身份证的有效性
function isIdCardNo(num){
	var factorArr = new Array(7,9,10,5,8,4,2,1,6,3,7,9,10,5,8,4,2,1);
    var error;
    var varArray = new Array();
    var intValue;
    var lngProduct = 0;
    var intCheckDigit;
    var intStrLen = num.length;
    var idNumber = num;   
    // initialize
    if ((intStrLen != 15) && (intStrLen != 18)) {
        //error = "输入身份证号码长度不对！";
        //alert(error);
        //frmAddUser.txtIDCard.focus();
        return false;
    }   
    // check and set value
    for(i=0;i<intStrLen;i++) {
        varArray[i] = idNumber.charAt(i);
        if ((varArray[i] < '0' || varArray[i] > '9') && (i != 17)) {
            //error = "错误的身份证号码！.";
            //alert(error);
            //frmAddUser.txtIDCard.focus();
            return false;
        } else if (i < 17) {
            varArray[i] = varArray[i]*factorArr[i];
        }
    }
    if (intStrLen == 18) {
        //check date
        var date8 = idNumber.substring(6,14);
        if (checkDate(date8) == false) {
            //error = "身份证中日期信息不正确！.";
            //alert(error);
            return false;
        }       
        // calculate the sum of the products
        for(i=0;i<17;i++) {
            lngProduct = lngProduct + varArray[i];
        }       
        // calculate the check digit
        intCheckDigit = 12 - lngProduct % 11;
        switch (intCheckDigit) {
            case 10:
                intCheckDigit = 'X';
                break;
            case 11:
                intCheckDigit = 0;
                break;
            case 12:
                intCheckDigit = 1;
                break;
        }       
        // check last digit
        if (varArray[17].toUpperCase() != intCheckDigit) {
            //error = "身份证效验位错误!...正确为： " + intCheckDigit + ".";
            //alert(error);
            return false;
        }
    }
    else{        //length is 15
        //check date
        var date6 = idNumber.substring(6,12);
        if (checkDate(date6) == false) {
            //alert("身份证日期信息有误！.");
            return false;
        }
    }
    //alert ("Correct.");
    return true;
}
function checkDate(d){
	
	var flage= false;
	var year = d.substring(0,4);
	var month = d.substring(4,6);
	var day = d.substring(6,8);
	if(year<=new Date().getFullYear()&&year >= '1900'){
		if(month<='12'&&month >='01'){
			if(day <='31'&&day>='01'){
				flage = true;
			}
		}
	}
	return flage;
	//d.substring(4,6)
}

//求num 的位数
function countNum(num){
	
	var c = 0;
	if(num!=''){
		var ys = num/10;
		
		c = 1;
		if(num>10){
			while(ys>10){
    			ys = ys/10;
    			c= c+1;
    		}
    		c=c+1;
		}
	}
	
	return c;
}