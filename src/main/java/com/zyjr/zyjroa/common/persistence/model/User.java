package com.zyjr.zyjroa.common.persistence.model;
import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;


public class User extends Model<User>{
    private static final long serialVersionUID = 1L;

	/**
	 *	主键id
	 */
	private Integer id;

	/**
	 *	头像
	 */
	private String avatar;

	/**
	 *	工号
	 */
	private String account;

	/**
	 *	密码
	 */
	private String password;

	/**
	 *	md5密码盐
	 */
	private String salt;

	/**
	 *	名字
	 */
	private String name;

	/**
	 *	生日
	 */
	private Date birthday;

	/**
	 *	性别（1：男 2：女）
	 */
	private Integer sex;

	/**
	 *	电子邮件
	 */
	private String email;

	/**
	 *	电话
	 */
	private String phone;

	/**
	 *	角色id
	 */
	private String roleid;

	/**
	 *	部门id
	 */
	private Integer deptid;

	/**
	 *	状态(1：启用  2：冻结  3：删除）
	 */
	private Integer status;

	/**
	 *	创建时间
	 */
	private Date createtime;

	/**
	 *	保留字段
	 */
	private Integer version;

	/**
	 *	工作岗位
	 */
	private String job;

	/**
	 *	员工类别1-试用期2-实习3-正式4-离职
	 */
	private Integer usertype;

	/**
	 *	职位类型
	 */
	private String jobtype;

	/**
	 *	职级
	 */
	private Integer levelid;

	/**
	 *	婚姻状况 0已婚 1未婚
	 */
	private Integer marriageStatus;

	/**
	 *	身份证号
	 */
	private String idcard;

	/**
	 *	名族
	 */
	private String nationality;

	/**
	 *	直属上级
	 */
	private Integer direct;

	/**
	 *	入职日期
	 */
	private String entrydate;

	/**
	 *	政治面貌
	 */
	private String politicalStatus;

	/**
	 *	参加工作时间
	 */
	private String startWorkTime;

	/**
	 *	籍贯
	 */
	private String nativePlace;

	/**
	 *	户籍类型
	 */
	private String registerType;

	/**
	 *	户籍地址
	 */
	private String registerAddress;

	/**
	 *	通讯地址
	 */
	private String contactAddress;

	/**
	 *	紧急联络人
	 */
	private String emergencyPerson;

	/**
	 *	紧急联络人号码
	 */
	private String emergencyMobile;

	/**
	 *	紧急联络人关系
	 */
	private String emergencyRelation;

	/**
	 *	紧急联系人地址
	 */
	private String emergencyAddress;

	/**
	 *	毕业院校
	 */
	private String graduateSchool;

	/**
	 *	专业
	 */
	private String major;

	/**
	 *	学历
	 */
	private String education;

	/**
	 *	学位
	 */
	private String degree;

	/**
	 *	职称
	 */
	private String professional;

	/**
	 *	合同签订甲方
	 */
	private String contractFirstPaty;

	/**
	 *	合同签订甲方描述
	 */
	private String firstpartyRemark;

	/**
	 *	合同起始日期
	 */
	private String contractStartDate;

	/**
	 *	试用期
	 */
	private Integer probation;

	/**
	 *	合同终止日期
	 */
	private String contractEndDate;

	/**
	 *	工资核算单位
	 */
	private String salaryAccountUnit;

	/**
	 *	工资卡号
	 */
	private String bankAccount;

	/**
	 *	银行卡开户行
	 */
	private String bank;

	/**
	 *	社保缴纳单位
	 */
	private String insuranceUnit;

	/**
	 *	
	 */
	private String insuranceRemark;

	/**
	 *	公积金缴纳单位
	 */
	private String accumulationUnit;

	/**
	 *	公积金缴纳单位描述
	 */
	private String accumulationRamark;

	/**
	 *	社保缴纳地
	 */
	private String insuranceAddress;

	/**
	 *	公积金缴纳地
	 */
	private String accumulationAddress;

	/**
	 *	工作地
	 */
	private String workAddress;

	/**
	 *	员工来源
	 */
	private String userSource;

	/**
	 *	工作经历
	 */
	private String workExpress;
	
	/**
	 *	转正日期
	 */
	private String translateDate;
	
	/**
	 *	离职日期
	 */
	private String leaveDate;

	public String getTranslateDate() {
		return translateDate;
	}

	public void setTranslateDate(String translateDate) {
		this.translateDate = translateDate;
	}

	public String getLeaveDate() {
		return leaveDate;
	}

	public void setLeaveDate(String leaveDate) {
		this.leaveDate = leaveDate;
	}

	public void setId(Integer id){
		this.id=id;
	}

	public Integer getId(){
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

	public void setSex(Integer sex){
		this.sex=sex;
	}

	public Integer getSex(){
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

	public void setDeptid(Integer deptid){
		this.deptid=deptid;
	}

	public Integer getDeptid(){
		return deptid;
	}

	public void setStatus(Integer status){
		this.status=status;
	}

	public Integer getStatus(){
		return status;
	}

	public void setCreatetime(Date createtime){
		this.createtime=createtime;
	}

	public Date getCreatetime(){
		return createtime;
	}

	public void setVersion(Integer version){
		this.version=version;
	}

	public Integer getVersion(){
		return version;
	}

	public void setJob(String job){
		this.job=job;
	}

	public String getJob(){
		return job;
	}

	public void setUsertype(Integer usertype){
		this.usertype=usertype;
	}

	public Integer getUsertype(){
		return usertype;
	}

	public void setJobtype(String jobtype){
		this.jobtype=jobtype;
	}

	public String getJobtype(){
		return jobtype;
	}

	public void setLevelid(Integer levelid){
		this.levelid=levelid;
	}

	public Integer getLevelid(){
		return levelid;
	}

	public void setMarriageStatus(Integer marriageStatus){
		this.marriageStatus=marriageStatus;
	}

	public Integer getMarriageStatus(){
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

	public void setDirect(Integer direct){
		this.direct=direct;
	}

	public Integer getDirect(){
		return direct;
	}

	public void setEntrydate(String entrydate){
		this.entrydate=entrydate;
	}

	public String getEntrydate(){
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

	public void setNativePlace(String nativePlace){
		this.nativePlace=nativePlace;
	}

	public String getNativePlace(){
		return nativePlace;
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

	public void setProbation(Integer probation){
		this.probation=probation;
	}

	public Integer getProbation(){
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

	public void setWorkExpress(String workExpress){
		this.workExpress=workExpress;
	}

	public String getWorkExpress(){
		return workExpress;
	}

	@Override
	protected Serializable pkVal() {
			return null;
	}

}

