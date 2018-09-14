/*
 * Copyright 2005 Joe Walker / Alexandru Popescu
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * Declare an object to which we can add real functions.
 */
if (dwr == null) var dwr = {};
if (dwr.webwork == null) dwr.webwork = {};
if (DWRActionUtil == null) var DWRActionUtil = dwr.webwork;

//每个异步请求的js的thread都greate个mark
maskshow = function (){
	var disabledComps = new Array();
		
	document.body.disabled = true;
	document.body.style.cursor="wait";	
	var tempMarkDiv = document.createElement("DIV");
	tempMarkDiv.className = "ext-el-mask";
	document.body.appendChild(tempMarkDiv);
		
//		var tempComps = document.getElementsByTagName("INPUT");
//		for(var i=0;i<tempComps.length;i++){
//			if(tempComps[i].disabled== false && tempComps[i].type=="button"){
//				tempComps[i].disabled = true;
//				disabledComps.push(tempComps[i]);
//			}
//		}
	return tempMarkDiv;
};
//hide自己的mask
maskhide = function (maskDiv){
	document.body.removeChild(maskDiv);	
	document.body.disabled = false;
	document.body.style.cursor = "";	
//		for(var i=0;i < disabledComps.length;i++){
//			
//			//alert(disabledComps[obj][i].value);
//			disabledComps[i].disabled = false;
//		}
};

/** Execute a remote request using DWR */
dwr.webwork.execute = function(action, values, callbackObjOrName) {
	
	var maskDiv;
	
		maskDiv= maskshow();

  
  var params = {};
  if (dwr.webwork.isElement(values)) {
    var element = $(values);
    var elementName= element.nodeName.toLowerCase();
    if (elementName == 'form') {
      for (var i = 0; i < element.elements.length; i=i+1) {
        var e = element.elements[i];
        if (e.name != null && e.name != '') params[e.name] = dwr.util.getValue(e);
      }
    }
    else {
      params[element.name] = dwr.util.getValue(element);
    }
  }
  else {
    for (var prop in values) {
      params[prop]= values[prop];
    }
  }

  // prepare action invocation object
  var actionObj = {};
  if (typeof action == 'string') {
    var lastIdx= action.lastIndexOf('/');
    actionObj.executeResult = 'true';
    if (lastIdx != -1) {
      actionObj.namespace = action.substring(0, lastIdx);
      actionObj.action = action.substring(lastIdx + 1);
    }
    else {
      actionObj.namespace= '';
      actionObj.action = action;
    }
  }
  else {
    actionObj= action;
  }

  // prepare the DWR callback object
  var callbackObj = {};
  var mustCall= false;
  if (typeof callbackObjOrName == 'string') {
    callbackObj.callback = function(dt) { dwr.webwork.callback(dt, eval(callbackObjOrName)); };
    mustCall= true;
	alert('st1');
  }
  else if (typeof callbackObjOrName == 'function') {

	callbackObj.callback = function(dt) { 
	
		maskhide(maskDiv);
		dwr.webwork.callback(dt, callbackObjOrName); 
		
	};
    mustCall= true;
  } 
  else if (typeof callbackObjOrName == 'object' && typeof callbackObjOrName.callback == 'function') {
  	alert('st3');
    for (var prop in callbackObjOrName) {
      callbackObj[prop] = callbackObjOrName[prop];
    }
    callbackObj.callback = function(dt) { dwr.webwork.callback(dt, callbackObjOrName.callback); };
    mustCall= true;
  }
  if (mustCall) {
    DWRAction.execute(actionObj, params, callbackObj);
	//document.body.disabled = false;
  }
};
/** Execute a remote request using DWR 
*  because of  "radio" return value is 'true' or 'false'  add this method.
*/
dwr.webwork.execute2 = function(action, values, callbackObjOrName) {
  var params = {};
  if (dwr.webwork.isElement(values)) {
    var element = $(values);
    var elementName= element.nodeName.toLowerCase();
    if (elementName == 'form') {
      for (var i = 0; i < element.elements.length; i=i+1) {
        var e = element.elements[i];
        if (e.name != null && e.name != '') params[e.name] = dwr.util.getValue(e.name);//
      }
    }
    else {
      params[element.name] = dwr.util.getValue(element);
    }
  }
  else {
    for (var prop in values) {
      params[prop]= values[prop];
    }
  }

  // prepare action invocation object
  var actionObj = {};
  if (typeof action == 'string') {
    var lastIdx= action.lastIndexOf('/');
    actionObj.executeResult = 'true';
    if (lastIdx != -1) {
      actionObj.namespace = action.substring(0, lastIdx);
      actionObj.action = action.substring(lastIdx + 1);
    }
    else {
      actionObj.namespace= '';
      actionObj.action = action;
    }
  }
  else {
    actionObj= action;
  }

  // prepare the DWR callback object
  var callbackObj = {};
  var mustCall= false;
  if (typeof callbackObjOrName == 'string') {
    callbackObj.callback = function(dt) { dwr.webwork.callback(dt, eval(callbackObjOrName)); };
    mustCall= true;
  }
  else if (typeof callbackObjOrName == 'function') {
    callbackObj.callback = function(dt) { dwr.webwork.callback(dt, callbackObjOrName); };
    mustCall= true;
  } 
  else if (typeof callbackObjOrName == 'object' && typeof callbackObjOrName.callback == 'function') {
    for (var prop in callbackObjOrName) {
      callbackObj[prop] = callbackObjOrName[prop];
    }
    callbackObj.callback = function(dt) { dwr.webwork.callback(dt, callbackObjOrName.callback); };
    mustCall= true;
  }
  if (mustCall) {
    DWRAction.execute(actionObj, params, callbackObj);
  }
};
/** Execute a remote request using DWR */
dwr.webwork.callback = function(dt, originalCallback) {
  if (dt.data) originalCallback(dt.data);
  else if (dt.text) originalCallback(dt.text);
  else originalCallback(dt);
  
};

/** Utility to check to see if the passed object is an input element / element id */
dwr.webwork.isElement = function(elementOrId) {
  if (typeof elementOrId == "string") {
    return true;
  }
  if (elementOrId.nodeName) {
    var name= elementOrId.nodeName.toLowerCase();
    if (name == 'input' || name == 'form') {
      return true;
    }
  }

  return false;
};
