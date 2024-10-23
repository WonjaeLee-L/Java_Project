package __0__project_dao;

public class companyDAO extends _connection{
	private static companyDAO companydao = null;

	private companyDAO() {
		init();
	}

	public static companyDAO getInstance() {
		if (companydao == null) {
			companydao = new companyDAO();
		}
		return companydao;
	}
}
