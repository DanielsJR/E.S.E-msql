package nx.ESE.entities;


public enum Role{
	ADMIN, MANAGER, TEACHER, STUDENT, PROXY, AUTHENTICATED;

	public String roleName() {
		return "ROLE_" + this.toString();
	}

}
