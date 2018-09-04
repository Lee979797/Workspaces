/*****************************************************************************
 gastax_data.js
 
******************************************************************************
 Written in 2004 by 
    Brian Douglas Skinner <brian.skinner@gumption.org>
  
 Copyright rights relinquished under the Creative Commons  
 Public Domain Dedication:
    http://creativecommons.org/licenses/publicdomain/
  
 You can copy freely from this file.  This work may be freely reproduced, 
 distributed, transmitted, used, modified, built upon, or otherwise exploited
 by anyone for any purpose.
  
 This work is provided on an "AS IS" basis, without warranties or conditions 
 of any kind, either express or implied, including, without limitation, any 
 warranties or conditions of title, non-infringement, merchantability, or 
 fitness for a particular purpose. You are solely responsible for determining 
 the appropriateness of using or distributing the work and assume all risks 
 associated with use of this work, including but not limited to the risks and 
 costs of errors, compliance with applicable laws, damage to or loss of data 
 or equipment, and unavailability or interruption of operations.

 In no event shall the authors or contributors have any liability for any 
 direct, indirect, incidental, special, exemplary, or consequential damages,
 however caused and on any theory of liability, whether in contract, strict 
 liability, or tort (including negligence), arising in any way out of or in 
 connection with the use or distribution of the work.
*****************************************************************************/

function makeGastaxDataVortex() {
  var metricAccounts = new Metric("Test", Datatype.STRING);

  // Axes
  var axisType = new Axis("���");
  var axisZone = new Axis("��������");
  var axisForm = new Axis("��");

  // Year buckets
  var bucketOut = axisType.makeNewBucket("�ⲿ��������");
  var bucketCol = axisType.makeNewBucket("�ɼ�����");
  var bucketImage = axisType.makeNewBucket("ͼƬ����");
  var bucketClass = axisType.makeNewBucket("��������");
  var bucketStandard = axisType.makeNewBucket("ִ�б�׼����");
  var bucketTotal = axisType.makeNewBucket("����");
  var bucketEntTotal = axisType.makeNewBucket("��ҵ����");

  // Charity buckets



  /*var bucketCharityGreenbelt = axisCharity.makeNewBucket("������");
  var bucketCharityITDP      = axisCharity.makeNewBucket("�����");*/
  /*var bucketCharityIBF       = axisCharity.makeNewBucket("�ӱ�ʡ");*/


  // Amount buckets
  var bucketFormEnt      = axisForm.makeNewBucket("��ҵ��");
  var bucketFormProduct  = axisForm.makeNewBucket("��Ʒ��");
  var bucketFormEntPec   = axisForm.makeNewBucket("��ҵռ�����ٷֱ�");
  var bucketFormProductPec  = axisForm.makeNewBucket("��Ʒռ�����ٷֱ�");


  var gastaxDataVortex = new DataVortex([axisForm,axisType,axisZone]);
  gastaxDataVortex.metricList.push(metricAccounts);

  var dj = document.getElementById("dj").value;
  var xzqh = document.getElementById("xzqh").value;

  dwr.engine.setAsync(false);
  static.listXzqhStaticData(dj,xzqh,function(data){
      if(data.length>0){
          for(var i=0;i<data.length;i++){
              var operator;
              var common;
              if('zxs'==dj||'third'==dj||('second'==dj&&data[i].workUnit.substring(2)=='0000')){
                  operator = 'oper=equal';
                  common = axisZone.makeNewBucket(data[i].workUnitName);
              }else{
                  operator = 'oper=like';
                  common = axisZone.makeNewBucket('<a style="color:#fff;" href="newXzqhDataDetail.jsp?dj=third&xzqh='+data[i].workUnit+'">'+data[i].workUnitName+'</a>');
              }

              gastaxDataVortex.setValue(metricAccounts,  '<a title="�鿴�������" href="../enterpriseinfomation/entstatic.jsp?'+operator+'&flag=eb&workUnit='+data[i].workUnit+'">'+data[i].entbeian+'</a>', [bucketOut, common, bucketFormEnt])
              gastaxDataVortex.setValue(metricAccounts,  '<a title="�鿴�������" href="../enterpriseinfomation/productStatic.jsp?'+operator+'&flag=pb&workUnit='+data[i].workUnit+'">'+data[i].pbeian+'</a>', [bucketOut, common, bucketFormProduct])
              gastaxDataVortex.setValue(metricAccounts,  data[i].entbeianwcl, [bucketOut, common, bucketFormEntPec])
              gastaxDataVortex.setValue(metricAccounts,  data[i].pbeianwcl, [bucketOut, common, bucketFormProductPec])

              gastaxDataVortex.setValue(metricAccounts,  '<a title="�鿴�������" href="../enterpriseinfomation/entstatic.jsp?'+operator+'&flag=ec&workUnit='+data[i].workUnit+'">'+data[i].entcol+'</a>', [bucketCol, common, bucketFormEnt])
              gastaxDataVortex.setValue(metricAccounts,  '<a title="�鿴�������" href="../enterpriseinfomation/productStatic.jsp?'+operator+'&flag=pc&workUnit='+data[i].workUnit+'">'+data[i].pcol+'</a>', [bucketCol, common, bucketFormProduct])
              gastaxDataVortex.setValue(metricAccounts,  data[i].entcolwcl, [bucketCol, common, bucketFormEntPec])
              gastaxDataVortex.setValue(metricAccounts,  data[i].pcolwcl, [bucketCol, common, bucketFormProductPec])

              gastaxDataVortex.setValue(metricAccounts,  '<a title="�鿴�������" href="../enterpriseinfomation/entstatic.jsp?'+operator+'&flag=et&workUnit='+data[i].workUnit+'">'+data[i].eimage+'</a>', [bucketImage, common, bucketFormEnt])
              gastaxDataVortex.setValue(metricAccounts,  '<a title="�鿴�������" href="../enterpriseinfomation/productStatic.jsp?'+operator+'&flag=pt&workUnit='+data[i].workUnit+'">'+data[i].pimage+'</a>', [bucketImage, common, bucketFormProduct])
              gastaxDataVortex.setValue(metricAccounts,  data[i].eimgwcl, [bucketImage, common, bucketFormEntPec])
              gastaxDataVortex.setValue(metricAccounts,  data[i].pimgwcl, [bucketImage, common, bucketFormProductPec])

              gastaxDataVortex.setValue(metricAccounts,  '<a title="�鿴�������" href="../enterpriseinfomation/entstatic.jsp?'+operator+'&flag=ec&workUnit='+data[i].workUnit+'">'+data[i].eclass+'</a>', [bucketClass, common, bucketFormEnt])
              gastaxDataVortex.setValue(metricAccounts,  '<a title="�鿴�������" href="../enterpriseinfomation/productStatic.jsp?'+operator+'&flag=pc&workUnit='+data[i].workUnit+'">'+data[i].pclass+'</a>', [bucketClass, common, bucketFormProduct])
              gastaxDataVortex.setValue(metricAccounts,  data[i].eclasswcl, [bucketClass, common, bucketFormEntPec])
              gastaxDataVortex.setValue(metricAccounts,  data[i].pclasswcl, [bucketClass, common, bucketFormProductPec])

              gastaxDataVortex.setValue(metricAccounts,  '<a title="�鿴�������" href="../enterpriseinfomation/entstatic.jsp?'+operator+'&flag=es&workUnit='+data[i].workUnit+'">'+data[i].estandard+'</a>', [bucketStandard, common, bucketFormEnt])
              gastaxDataVortex.setValue(metricAccounts,  '<a title="�鿴�������" href="../enterpriseinfomation/productStatic.jsp?'+operator+'&flag=ps&workUnit='+data[i].workUnit+'">'+data[i].pstandard+'</a>', [bucketStandard, common, bucketFormProduct])
              gastaxDataVortex.setValue(metricAccounts,  data[i].estandardwcl, [bucketStandard, common, bucketFormEntPec])
              gastaxDataVortex.setValue(metricAccounts,  data[i].pstandardwcl, [bucketStandard, common, bucketFormProductPec])

              gastaxDataVortex.setValue(metricAccounts,  data[i].alle, [bucketTotal, common, bucketFormEnt])
              gastaxDataVortex.setValue(metricAccounts,  data[i].allp, [bucketTotal, common, bucketFormProduct])
              gastaxDataVortex.setValue(metricAccounts,  "", [bucketTotal, common, bucketFormEntPec])
              gastaxDataVortex.setValue(metricAccounts,  "", [bucketTotal, common, bucketFormProductPec])
              dwr.engine.setAsync(false);
              if(dj=='thrid'||dj=='zxs'){
                  static.staticXzqhThirdTotal(data[i].workUnit,function(total){
                      gastaxDataVortex.setValue(metricAccounts,  total, [bucketEntTotal, common, bucketFormEnt])
                      gastaxDataVortex.setValue(metricAccounts,  "", [bucketEntTotal, common, bucketFormProduct])
                      gastaxDataVortex.setValue(metricAccounts,  "", [bucketEntTotal, common, bucketFormEntPec])
                      gastaxDataVortex.setValue(metricAccounts,  "", [bucketEntTotal, common, bucketFormProductPec])
                  });
              }else{
                  static.staticXzqhTotal(data[i].workUnit.substring(0,4),function(total){
                      gastaxDataVortex.setValue(metricAccounts,  total, [bucketEntTotal, common, bucketFormEnt])
                      gastaxDataVortex.setValue(metricAccounts,  "", [bucketEntTotal, common, bucketFormProduct])
                      gastaxDataVortex.setValue(metricAccounts,  "", [bucketEntTotal, common, bucketFormEntPec])
                      gastaxDataVortex.setValue(metricAccounts,  "", [bucketEntTotal, common, bucketFormProductPec])
                  });
              }

          }
      }else{
          ymPrompt.alert({message:"��ʱû�����ݣ�", width:330, height:220, title:'��ʾ��Ϣ'});
      }
      var gastaxPivot  = new PivotTable("tableOne", gastaxDataVortex, [gastaxDataVortex.axisList[2], gastaxDataVortex.axisList[0]], [gastaxDataVortex.axisList[1]]);
      gastaxPivot.display();
  }
  );
  dwr.engine.setAsync(true);

}
