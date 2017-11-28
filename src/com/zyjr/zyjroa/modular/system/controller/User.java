package com.zyjr.zyjroa.modular.system.controller;
import java.util.Date;

   /**
    * user 实体类
    * Wed Nov 15 16:19:02 CST 2017 weisg
    */ 


public class User{
	private int id;
	private String avatar;
	private String account;
	private String password;
	private String salt;
	private String name;
	private Date birthday;
	private int sex;
	private String email;
	private String phone;
	private String roleid;
	private int deptid;
	private int status;
	private Date createtime;
	private int version;
	private String job;
	private int usertype;
	private String jobtype;
	private int levelid;
	private int marriageStatus;
	private String idcard;
	private String nationality;
	private int direct;
	private Date entrydate;
	private String politicalStatus;
	private String startWorkTime;
	private String native;
	private String registerType;
	private String registerAddress;
	private String contactAddress;
	private String emergencyPerson;
	private String emergencyMobile;
	private String emergencyRelation;
	private String emergencyAddress;
	private String graduateSchool;
	private String major;
	private String education;
	private String degree;
	private String professional;
	private String contractFirstPaty;
	private String firstpartyRemark;
	private String contractStartDate;
	private int probation;
	private String contractEndDate;
	private String salaryAccountUnit;
	private String bankAccount;
	private String bank;
	private String insuranceUnit;
	private String insuranceRemark;
	private String accumulationUnit;
	private String accumulationRamark;
	private String insuranceAddress;
	private String accumulationAddress;
	private String workAddress;
	private String userSource;
	private String work-express;
	public void setId(int id){
		this.id=id;
	}
	public int getId(){
		return id;
	}
	public void setAvatar(String avatar){
		this.avatar=avatar;
	}
	public String getAvatar(){
		return avatar;
	}
	public void setAccount(String account){
		this.account=account;
	}
	public String getAccount(){
		return account;
	}
	public void setPassword(String password){
		this.password=password;
	}
	public String getPassword(){
		return password;
	}
	public void setSalt(String salt){
		this.salt=salt;
	}
	public String getSalt(){
		return salt;
	}
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
	public void setBirthday(Date birthday){
		this.birthday=birthday;
	}
	public Date getBirthday(){
		return birthday;
	}
	public void setSex(int sex){
		this.sex=sex;
	}
	public int getSex(){
		return sex;
	}
	public void setEmail(String email){
		this.email=email;
	}
	public String getEmail(){
		return email;
	}
	public void setPhone(String phone){
		this.phone=phone;
	}
	public String getPhone(){
		return phone;
	}
	public void setRoleid(String roleid){
		this.roleid=roleid;
	}
	public String getRoleid(){
		return roleid;
	}
	public void setDeptid(int deptid){
		this.deptid=deptid;
	}
	public int getDeptid(){
		return deptid;
	}
	public void setStatus(int status){
		this.status=status;
	}
	public int getStatus(){
		return status;
	}
	public void setCreatetime(Date createtime){
		this.createtime=createtime;
	}
	public Date getCreatetime(){
		return createtime;
	}
	public void setVersion(int version){
		this.version=version;
	}
	public int getVersion(){
		return version;
	}
	public void setJob(String job){
		this.job=job;
	}
	public String getJob(){
		return job;
	}
	public void setUsertype(int usertype){
		this.usertype=usertype;
	}
	public int getUsertype(){
		return usertype;
	}
	public void setJobtype(String jobtype){
		this.jobtype=jobtype;
	}
	public String getJobtype(){
		return jobtype;
	}
	public void setLevelid(int levelid){
		this.levelid=levelid;
	}
	public int getLevelid(){
		return levelid;
	}
	public void setMarriageStatus(int marriageStatus){
		this.marriageStatus=marriageStatus;
	}
	public int getMarriageStatus(){
		return marriageStatus;
	}
	public void setIdcard(String idcard){
		this.idcard=idcard;
	}
	public String getIdcard(){
		return idcard;
	}
	public void setNationality(String nationality){
		this.nationality=nationality;
	}
	public String getNationality(){
		return nationality;
	}
	public void setDirect(int direct){
		this.direct=direct;
	}
	public int getDirect(){
		return direct;
	}
	public void setEntrydate(Date entrydate){
		this.entrydate=entrydate;
	}
	public Date getEntrydate(){
		return entrydate;
	}
	public void setPoliticalStatus(String politicalStatus){
		this.politicalStatus=politicalStatus;
	}
	public String getPoliticalStatus(){
		return politicalStatus;
	}
	public void setStartWorkTime(String startWorkTime){
		this.startWorkTime=startWorkTime;
	}
	public String getStartWorkTime(){
		return startWorkTime;
	}
	public void setNative(String native){
		this.native=native;
	}
	public String getNative(){
		return native;
	}
	public void setRegisterType(String registerType){
		this.registerType=registerType;
	}
	public String getRegisterType(){
		return registerType;
	}
	public void setRegisterAddress(String registerAddress){
		this.registerAddress=registerAddress;
	}
	public String getRegisterAddress(){
		return registerAddress;
	}
	public void setContactAddress(String contactAddress){
		this.contactAddress=contactAddress;
	}
	public String getContactAddress(){
		return contactAddress;
	}
	public void setEmergencyPerson(String emergencyPerson){
		this.emergencyPerson=emergencyPerson;
	}
	public String getEmergencyPerson(){
		return emergencyPerson;
	}
	public void setEmergencyMobile(String emergencyMobile){
		this.emergencyMobile=emergencyMobile;
	}
	public String getEmergencyMobile(){
		return emergencyMobile;
	}
	public void setEmergencyRelation(String emergencyRelation){
		this.emergencyRelation=emergencyRelation;
	}
	public String getEmergencyRelation(){
		return emergencyRelation;
	}
	public void setEmergencyAddress(String emergencyAddress){
		this.emergencyAddress=emergencyAddress;
	}
	public String getEmergencyAddress(){
		return emergencyAddress;
	}
	public void setGraduateSchool(String graduateSchool){
		this.graduateSchool=graduateSchool;
	}
	public String getGraduateSchool(){
		return graduateSchool;
	}
	public void setMajor(String major){
		this.major=major;
	}
	public String getMajor(){
		return major;
	}
	public void setEducation(String education){
		this.education=education;
	}
	public String getEducation(){
		return education;
	}
	public void setDegree(String degree){
		this.degree=degree;
	}
	public String getDegree(){
		return degree;
	}
	public void setProfessional(String professional){
		this.professional=professional;
	}
	public String getProfessional(){
		return professional;
	}
	public void setContractFirstPaty(String contractFirstPaty){
		this.contractFirstPaty=contractFirstPaty;
	}
	public String getContractFirstPaty(){
		return contractFirstPaty;
	}
	public void setFirstpartyRemark(String firstpartyRemark){
		this.firstpartyRemark=firstpartyRemark;
	}
	public String getFirstpartyRemark(){
		return firstpartyRemark;
	}
	public void setContractStartDate(String contractStartDate){
		this.contractStartDate=contractStartDate;
	}
	public String getContractStartDate(){
		return contractStartDate;
	}
	public void setProbation(int probation){
		this.probation=probation;
	}
	public int getProbation(){
		return probation;
	}
	public void setContractEndDate(String contractEndDate){
		this.contractEndDate=contractEndDate;
	}
	public String getContractEndDate(){
		return contractEndDate;
	}
	public void setSalaryAccountUnit(String salaryAccountUnit){
		this.salaryAccountUnit=salaryAccountUnit;
	}
	public String getSalaryAccountUnit(){
		return salaryAccountUnit;
	}
	public void setBankAccount(String bankAccount){
		this.bankAccount=bankAccount;
	}
	public String getBankAccount(){
		return bankAccount;
	}
	public void setBank(String bank){
		this.bank=bank;
	}
	public String getBank(){
		return bank;
	}
	public void setInsuranceUnit(String insuranceUnit){
		this.insuranceUnit=insuranceUnit;
	}
	public String getInsuranceUnit(){
		return insuranceUnit;
	}
	public void setInsuranceRemark(String insuranceRemark){
		this.insuranceRemark=insuranceRemark;
	}
	public String getInsuranceRemark(){
		return insuranceRemark;
	}
	public void setAccumulationUnit(String accumulationUnit){
		this.accumulationUnit=accumulationUnit;
	}
	public String getAccumulationUnit(){
		return accumulationUnit;
	}
	public void setAccumulationRamark(String accumulationRamark){
		this.accumulationRamark=accumulationRamark;
	}
	public String getAccumulationRamark(){
		return accumulationRamark;
	}
	public void setInsuranceAddress(String insuranceAddress){
		this.insuranceAddress=insuranceAddress;
	}
	public String getInsuranceAddress(){
		return insuranceAddress;
	}
	public void setAccumulationAddress(String accumulationAddress){
		this.accumulationAddress=accumulationAddress;
	}
	public String getAccumulationAddress(){
		return accumulationAddress;
	}
	public void setWorkAddress(String workAddress){
		this.workAddress=workAddress;
	}
	public String getWorkAddress(){
		return workAddress;
	}
	public void setUserSource(String userSource){
		this.userSource=userSource;
	}
	public String getUserSource(){
		return userSource;
	}
	public void setWork-express(String work-express){
		this.work-express=work-express;
	}
	public String getWork-express(){
		return work-express;
	}
}

