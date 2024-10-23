package __0__project_dao;

public class blockedDAO extends _connection{
	private static blockedDAO blockeddao = null;

	private blockedDAO() {
		init();
	}

	public static blockedDAO getInstance() {
		if (blockeddao == null) {
			blockeddao = new blockedDAO();
		}
		return blockeddao;
	}

}
