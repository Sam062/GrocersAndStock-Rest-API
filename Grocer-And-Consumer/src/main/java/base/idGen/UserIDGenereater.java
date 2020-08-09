package base.idGen;

import java.io.Serializable;
import java.security.SecureRandom;
import java.util.stream.Collectors;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class UserIDGenereater implements IdentifierGenerator{
	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {

		String result = new SecureRandom().ints(0,36)
	            .mapToObj(i -> Integer.toString(i, 36))
	            .map(String::toUpperCase).distinct().limit(16).collect(Collectors.joining())
	            .replaceAll("([A-Z0-9]{4})", "$1-").substring(0,19);
		return result.toUpperCase();
	}
}
