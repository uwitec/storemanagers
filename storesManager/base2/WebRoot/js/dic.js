
//user_sts
function dic_userSts(val) {
	if ("0" == val) {
		return "停用";
	} else if ("1" == val) {
		return "正常";
	}
	return "未知";
}