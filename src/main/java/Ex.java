import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @创建人 PigAndCatWithWind
 * @创建时间 2021/2/25下午4:01
 * @描述
 */
@MappedJdbcTypes(JdbcType.VARBINARY)
public class Ex extends BaseTypeHandler<String> {
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, String s, JdbcType jdbcType) throws SQLException {

    }

    public String getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return null;
    }

    public String getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return null;
    }

    public String getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return null;
    }
}
