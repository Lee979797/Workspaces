*
* Ext JS Library 2.0
* Copyright(c) 2006-2007, Ext JS, LLC.
* licensing@extjs.com
* 
* http://extjs.com/license
*/


Ext.onReady(function(){ 
Ext.QuickTips.init();

    
//Ext.form.Field.prototype.msgTarget = 'side';
   
var fsf = new Ext.FormPanel({
        labelWidth: 100, // label settings here cascade unless overridden
        url:'save-form.php',
        frame:false,
        labelAlign: 'right',
        title: '恭喜你， dsxdddd!你的用户名可用，请继续填写以下资料。&nbsp;&nbsp;&nbsp;'+
      '&nbsp;&nbsp;&nbsp;&nbsp;有<font face="宋体" size="3" color="red">*</font>'+
      '标记的是必须项 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'+
      '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'+
      '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'+
      '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'+
      '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'+
      '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'+
      '&nbsp;&nbsp;&nbsp;&nbsp;<a href="#">注册帮助</a>',

//这里很多&nbsp;，呵呵！这样很不好，没办法，我想不到能有更好的方法，希望想到的朋友能给我点提示，谢了！
        bodyStyle:'padding:1px 35px 15px;',
        width: 900,

        items: [
      new Ext.Panel({ 
             border :false,
           html:'<h2><font color="green">设置密码</font></h2>'
    }),
    {
         layout: 'table',
        border :false,
                     items: [
         { 
        border:false,
        width:43
      },{
        border :false,
        html:'邮箱地址:',
                          width:65
                      },{
        border:false,
        html:'<b><font color="green">dsxdddd@126.com</font></b>'
       }]
                },    
    
      new Ext.Panel({ //设置空隙使看起来不会太挤
       border :false, 
       height:5
    }), 
    {
      border :false,
                  layout:'column',
                  items:[
          {
          border :false,
                         columnWidth:.5,
                         layout: 'form',
                         items: [
        {
                             border :false,
                                xtype:'textfield',
                                fieldLabel: '<font color="red">*</font> 密码',  
                               allowBlank:false,
                             anchor:'95%'
                        }]
                },{
                  
                    layout: 'form',
                  border :false,
                   columnWidth:.5,
                    items: [
       new Ext.Panel({
               border :false,
                html:'<font size="2" color="#999999">*密码长度6~20位，由英文字母a~z(区分大小写),数字0~9，特殊字符组成。</font>'
                                     })       
                     ]}
         ]},
     {
         layout: 'table',
       border :false,
                     items: [{
        border :false,
                          width:105
                      },{
        border:false,
        html:'<img src="3.jpg" height="20" width="285"/>'
       }]
                },
  
       new Ext.form.TextField({
                    fieldLabel: '<font color="red">*</font> 请再次输入密码',
                    name: 'repossword',
        width:288,
        border :false,
        allowBlank:false
      }),
     new Ext.Panel({ //设置一个空行，布局美观
                    html:'<br>',
                    border :false
               }) ,     
             new Ext.Panel({ 
              border :false,
              html:'<hr>' 
      }),
             new Ext.Panel({ 
               border :false,
              html:'<h2><font color="green">密码保护设置</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'+
       '<font face="宋体" size="2" color="red">为了保障邮箱安全，请至少选择两种方式进行填写并牢记。</font></h2>'
             }), 
        {
               layout:'column',
               border :false,
               items:[
       { 
         border :false,
                     columnWidth:.5,
                     layout: 'form',
                     items: [
       {
                          xtype:'textfield',
                          fieldLabel: '<font color="red">1、</font> 常用邮箱',
                          name: 'cyyx',
                        border :false,
                          blankText: ' ',                
                        anchor:'95%'
                       }]
             },{
                columnWidth:.4,
                layout: 'form',
              border :false,
                items: [
      new Ext.Panel({
            border :false,
                        html:'<font size="2" color="#999999">*万一你遇到问题或忘记密码，可以通过此邮箱联系取回</font>'
                    })       
                       ]
                 }
        ]},
       new Ext.Panel({ 
        border :false,
        height:5
     }),
    {
                layout:'column',
              border :false,
                items:[
       { 
                   border :false,
                    columnWidth:.5,
                    layout: 'form',
                    items: [{
                       xtype:'textfield',
                       fieldLabel: '<font color="red">2、</font> 手机号码',
                       name: 'sjh',
                      border :false,
                       blankText: ' ',
                       anchor:'95%'
                      }]
                    },
          new Ext.Panel({
        border :false,
        height:5 
       }),{
                        columnWidth:.4,
                        layout: 'form',
                        border :false,
                        items: [
            new Ext.Panel({ 
                          border :false,
                                html:'<font size="2" color="#999999">*通过手机可以取回密码</font>'
                           })       
                               ]
                        }
       ]},
       new Ext.Panel({ 
      border :false,
        height:5
     }),
          new Ext.form.ComboBox({
                    fieldLabel: '<font color="red">3、</font>密码提示问题',
                    iddenName:'state',
                    border :false,
                    store: new Ext.data.SimpleStore({
                               fields: ['abbr', 'state'],
                               data : Ext.exampledata.states // from states.js
                            }),
                        valueField:'abbr',
                        displayField:'state',
                        typeAhead: true,
                        mode: 'local',
                        triggerAction: 'all',
                        emptyText:'请选择你的密码提示问题',
                        selectOnFocus:false,
                        width:288
                  }),
         new Ext.Panel({
       border :false,
       height:5
      }),
         new Ext.form.TextField({
                      fieldLabel: '答&nbsp;案',
                     border :false,
                      name: 'DA',
                      width:288
       }),
       new Ext.Panel({
        border :false,
        height:5 
      }),

	new Ext.Panel({ 
         border :false,
           html:'<hr>'
       }),
                new Ext.Panel({
                     border :false,
                     html:'<h2><font color="green">个人资料</font></h2>'
                }),
          new Ext.form.DateField({
                      fieldLabel: '<font color="red">*</font> 出生日期',
                      border :false,
                      name: 'csrq',
                      width:288,
                      allowBlank:false
                   }),
       new Ext.Panel({ 
                       border :false,
                     height:5
       }),
     {
                    layout:'table',
                    bodyStyle: 'font-size: 12px;',
                    border :false,
                    items:[
                       { 
                    border :false,
                     width: 63
                       }, 
       { 
                    border :false,
                     html: '<font color="red">*</font>性&nbsp;别:',
                     width: 60
                       },{
         border :false,
         width:70,
                        items: [ 
             new Ext.form.Radio({ 
                               border :false,                             
              boxLabel:'男',
              checked:true,
                name:'p'
                   })]
                     },{
       border :false,
       width:100,
       items: [ 
        new Ext.form.Radio({ 
                               border :false,
                               boxLabel:'女', 
              name:'p'
              })]
      
      }
     ]}, 
       new Ext.Panel({ 
        border :false,
        height:5
      }),
       new Ext.form.ComboBox({ 
                      border :false,
                       fieldLabel: '年&nbsp;龄',
                       hiddenName:'state',
                       store: new Ext.data.SimpleStore({
                                  fields: ['abbr', 'state'],
                                  data : Ext.exampledata.states2 // from states2.js
                          }),
                          valueField:'abbr',
                          displayField:'state',
                          typeAhead: true,
                          mode: 'local',
                          triggerAction: 'all',
                          emptyText:' 请选择',
                          selectOnFocus:false,
                          width:288
                   }),
      new Ext.Panel({ 
       border :false,
       height:5
       }), 
      new Ext.form.ComboBox({
                        border :false,
                        fieldLabel: '最高学历',
                        hiddenName:'state',
                        store: new Ext.data.SimpleStore({
                                   fields: ['abbr', 'state'],
                                   data : Ext.exampledata.states3 // from states3.js
                           }),
                           valueField:'abbr',
                           displayField:'state',
                           typeAhead: true,
                           mode: 'local',
                           triggerAction: 'all',
                           emptyText:'请选择',
                           selectOnFocus:false,
                           width:288
                   }),
      new Ext.Panel({
       border :false,
       height:5
       }),
      new Ext.form.ComboBox({
                       border :false,
                        fieldLabel: '个人月收入',
                        hiddenName:'state',
                        store: new Ext.data.SimpleStore({
                                   fields: ['abbr', 'state'],
                                   data : Ext.exampledata.states4 // from states4.js
                           }),
                           valueField:'abbr',
                           displayField:'state',
                           typeAhead: true,
                           mode: 'local',
                           triggerAction: 'all',
                           emptyText:'请选择',
                           selectOnFocus:false,
                           width:288
                   }),
      new Ext.Panel({
       border :false,
       height:5
       }),
                    new Ext.form.ComboBox({
                      border :false,
                        fieldLabel: '所在省',
                        hiddenName:'state',
                        store: new Ext.data.SimpleStore({
                                   fields: ['abbr', 'state'],
                                   data : Ext.exampledata.states5 // from states5.js
                          }),
                           valueField:'abbr',
                           displayField:'state',
                           typeAhead: true,
                           mode: 'local',
                           triggerAction: 'all',
                           emptyText:'-省/直辖市-',
                           selectOnFocus:false,
                           width:288
                    }),   
      new Ext.Panel({
            border :false,
            height:5 
      }),
      new Ext.form.ComboBox({ 
                              border :false,
                              fieldLabel: '所在城市',
                              hiddenName:'state',
                              store: new Ext.data.SimpleStore({
                                             fields: ['abbr', 'state'],
                                             data : Ext.exampledata.states6 // from states6.js
                             }),
                               valueField:'abbr',
                               displayField:'state',
                               typeAhead: true,
                               mode: 'local',
                               triggerAction: 'all',
                               emptyText:'-地区/城市-',
                               selectOnFocus:false,
                               width:288
                     }), 
       new Ext.Panel({ //设置一个空行，布局美观
                             border :false,
                              html:'<br>'
                     }) ,

                      new Ext.Panel({
            border :false, 
            html:'<hr>' 
      }),
                  new Ext.Panel({ 
                     border :false,
                       html:'<h2><font color="green">注册确认</font></h2>'
                 }),
       {
                 layout:'column',
                   border :false,
                 items:[{ 
                      border :false,
                     columnWidth:.3,
                     layout: 'form',
                     items: [{ 
                         border :false,
                         xtype:'textfield',
       fieldLabel: '<font color="red">*</font>请输入右图字符',
          name: 'checksum',
          blankText: '请输入验证码!',
          allowBlank:false,
        anchor:'95%'
                      }]
                  },{
         columnWidth:.5,
      layout: 'form',
      border :false,
      items: [ new Ext.Panel({ 
                border :false,
                                  html:'<div >&nbsp;&nbsp;&nbsp;&nbsp;<img height=20 width=55 src=2.jpg></img>'+
            '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#" style="border-color:#468C38">'+
             '<img src="1.jpg" style="border-color:#468C38"/></a></div>'
                           })]
                     }]
                 } 
            ]});
    fsf.render(document.body);
    
});

