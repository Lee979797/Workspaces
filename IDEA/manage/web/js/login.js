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
        title: '��ϲ�㣬 dsxdddd!����û������ã��������д�������ϡ�&nbsp;&nbsp;&nbsp;'+
      '&nbsp;&nbsp;&nbsp;&nbsp;��<font face="����" size="3" color="red">*</font>'+
      '��ǵ��Ǳ����� &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'+
      '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'+
      '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'+
      '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'+
      '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'+
      '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'+
      '&nbsp;&nbsp;&nbsp;&nbsp;<a href="#">ע�����</a>',

//����ܶ�&nbsp;���Ǻǣ������ܲ��ã�û�취�����벻�����и��õķ�����ϣ���뵽�������ܸ��ҵ���ʾ��л�ˣ�
        bodyStyle:'padding:1px 35px 15px;',
        width: 900,

        items: [
      new Ext.Panel({ 
             border :false,
           html:'<h2><font color="green">��������</font></h2>'
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
        html:'�����ַ:',
                          width:65
                      },{
        border:false,
        html:'<b><font color="green">dsxdddd@126.com</font></b>'
       }]
                },    
    
      new Ext.Panel({ //���ÿ�϶ʹ����������̫��
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
                                fieldLabel: '<font color="red">*</font> ����',  
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
                html:'<font size="2" color="#999999">*���볤��6~20λ����Ӣ����ĸa~z(���ִ�Сд),����0~9�������ַ���ɡ�</font>'
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
                    fieldLabel: '<font color="red">*</font> ���ٴ���������',
                    name: 'repossword',
        width:288,
        border :false,
        allowBlank:false
      }),
     new Ext.Panel({ //����һ�����У���������
                    html:'<br>',
                    border :false
               }) ,     
             new Ext.Panel({ 
              border :false,
              html:'<hr>' 
      }),
             new Ext.Panel({ 
               border :false,
              html:'<h2><font color="green">���뱣������</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'+
       '<font face="����" size="2" color="red">Ϊ�˱������䰲ȫ��������ѡ�����ַ�ʽ������д���μǡ�</font></h2>'
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
                          fieldLabel: '<font color="red">1��</font> ��������',
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
                        html:'<font size="2" color="#999999">*��һ������������������룬����ͨ����������ϵȡ��</font>'
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
                       fieldLabel: '<font color="red">2��</font> �ֻ�����',
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
                                html:'<font size="2" color="#999999">*ͨ���ֻ�����ȡ������</font>'
                           })       
                               ]
                        }
       ]},
       new Ext.Panel({ 
      border :false,
        height:5
     }),
          new Ext.form.ComboBox({
                    fieldLabel: '<font color="red">3��</font>������ʾ����',
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
                        emptyText:'��ѡ�����������ʾ����',
                        selectOnFocus:false,
                        width:288
                  }),
         new Ext.Panel({
       border :false,
       height:5
      }),
         new Ext.form.TextField({
                      fieldLabel: '��&nbsp;��',
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
                     html:'<h2><font color="green">��������</font></h2>'
                }),
          new Ext.form.DateField({
                      fieldLabel: '<font color="red">*</font> ��������',
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
                     html: '<font color="red">*</font>��&nbsp;��:',
                     width: 60
                       },{
         border :false,
         width:70,
                        items: [ 
             new Ext.form.Radio({ 
                               border :false,                             
              boxLabel:'��',
              checked:true,
                name:'p'
                   })]
                     },{
       border :false,
       width:100,
       items: [ 
        new Ext.form.Radio({ 
                               border :false,
                               boxLabel:'Ů', 
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
                       fieldLabel: '��&nbsp;��',
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
                          emptyText:' ��ѡ��',
                          selectOnFocus:false,
                          width:288
                   }),
      new Ext.Panel({ 
       border :false,
       height:5
       }), 
      new Ext.form.ComboBox({
                        border :false,
                        fieldLabel: '���ѧ��',
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
                           emptyText:'��ѡ��',
                           selectOnFocus:false,
                           width:288
                   }),
      new Ext.Panel({
       border :false,
       height:5
       }),
      new Ext.form.ComboBox({
                       border :false,
                        fieldLabel: '����������',
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
                           emptyText:'��ѡ��',
                           selectOnFocus:false,
                           width:288
                   }),
      new Ext.Panel({
       border :false,
       height:5
       }),
                    new Ext.form.ComboBox({
                      border :false,
                        fieldLabel: '����ʡ',
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
                           emptyText:'-ʡ/ֱϽ��-',
                           selectOnFocus:false,
                           width:288
                    }),   
      new Ext.Panel({
            border :false,
            height:5 
      }),
      new Ext.form.ComboBox({ 
                              border :false,
                              fieldLabel: '���ڳ���',
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
                               emptyText:'-����/����-',
                               selectOnFocus:false,
                               width:288
                     }), 
       new Ext.Panel({ //����һ�����У���������
                             border :false,
                              html:'<br>'
                     }) ,

                      new Ext.Panel({
            border :false, 
            html:'<hr>' 
      }),
                  new Ext.Panel({ 
                     border :false,
                       html:'<h2><font color="green">ע��ȷ��</font></h2>'
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
       fieldLabel: '<font color="red">*</font>��������ͼ�ַ�',
          name: 'checksum',
          blankText: '��������֤��!',
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

