package util;

import java.io.IOException;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class IbatisUtils {

	private static SqlMapClient sqlMapClient;
	
	static {
		try {
			sqlMapClient = SqlMapClientBuilder.buildSqlMapClient(Resources.getResourceAsReader("dao/ibatis/sqlMapConfig.xml"));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	public static SqlMapClient getSqlMapClient() {
		return sqlMapClient;
	}
}
