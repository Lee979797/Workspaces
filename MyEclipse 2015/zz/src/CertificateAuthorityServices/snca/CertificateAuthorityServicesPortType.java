/**
 * CertificateAuthorityServicesPortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package CertificateAuthorityServices.snca;

public interface CertificateAuthorityServicesPortType extends java.rmi.Remote {
    public java.lang.String getTaxationApplicationCode(java.lang.String pkcs7) throws java.rmi.RemoteException;
    public com.snca.caplatform.services.domailmodel.xsd.SNCACertificate getSNCAPKCS7Certificate(java.lang.String PKCS7Info) throws java.rmi.RemoteException;
    public com.snca.caplatform.services.domailmodel.xsd.SNCACertificate getSNCAPublicKeyCertificate(java.lang.String base64Info) throws java.rmi.RemoteException;
    public java.lang.Boolean checkSNCAPKCS7CertificateAndSave(java.lang.String PKCS7Info, java.lang.String app_id, java.lang.String extend_id) throws java.rmi.RemoteException;
    public java.lang.Boolean checkSNCAPKCS7Certificate(java.lang.String PKCS7Info) throws java.rmi.RemoteException;
    public java.lang.String verifySignCS(java.lang.String signedText) throws java.rmi.RemoteException;
    public java.lang.Boolean checkSNCAPKCS7SignAndSaveToDB(java.lang.String PKCS7Info, java.lang.String service_id, java.lang.String app_id, java.lang.String extend_id) throws java.rmi.RemoteException;
    public java.lang.String getSNCAOID(java.lang.String in, java.lang.String type, java.lang.String expendingItemKey) throws java.rmi.RemoteException;
    public java.lang.Integer verifysignByCondtion(java.lang.String content, java.lang.String pkcs7, java.lang.String cer) throws java.rmi.RemoteException;
    public java.lang.Boolean checkSNCAPublicKeyCertificate2(java.lang.String orgId, java.lang.String appId, java.lang.String base64Info) throws java.rmi.RemoteException;
    public java.lang.String getSignContentByAppid(java.lang.String app_id, java.lang.String extend_id) throws java.rmi.RemoteException;
    public java.lang.String getTaxationCode(java.lang.String pkcs7) throws java.rmi.RemoteException;
    public java.lang.String getUserByOID(java.lang.String orgId, java.lang.String appId, java.lang.String OID) throws java.rmi.RemoteException;
    public java.lang.Boolean checkSNCAPKCS7CertificateTest1(java.lang.String PKCS7Info) throws java.rmi.RemoteException;
    public java.lang.Boolean verifysignBySNCAPublicCertificate(java.lang.String clearText, java.lang.String ciphertext, java.lang.String digAlgorithm, java.lang.String publicKey, java.lang.String asymmetricAlgorithmName) throws java.rmi.RemoteException;
    public java.lang.Boolean checkSNCAPublicKeyCertificate(java.lang.String base64Info) throws java.rmi.RemoteException;
    public java.lang.String getTaxationManageCode(java.lang.String pkcs7) throws java.rmi.RemoteException;
    public java.lang.Boolean checkSNCAPKCS7SignAndSaveToLISDB(java.lang.String PKCS7Info, java.lang.String service_id, java.lang.String app_id, java.lang.String extend_id) throws java.rmi.RemoteException;
    public java.lang.Boolean checkSNCAPKCS7Certificate2(java.lang.String orgId, java.lang.String appId, java.lang.String PKCS7Info) throws java.rmi.RemoteException;
    public java.lang.String getCurrentTime() throws java.rmi.RemoteException;
    public java.lang.String getSNCATrustNumber(java.lang.String in, java.lang.String type, java.lang.String expendingItemKey) throws java.rmi.RemoteException;
    public java.lang.String getSignContentByAppidDB(java.lang.String service_id, java.lang.String app_id, java.lang.String extend_id, java.lang.String dateMonth) throws java.rmi.RemoteException;
}
