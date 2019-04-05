package com.example.namingstrategy;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomPhysicalNamingStrategy extends PhysicalNamingStrategyStandardImpl {

	private static final long serialVersionUID = -6136290474018632737L;

	@Value("${naming-strategy-prefix:''}")
	private String namingStrategyPrefix;

	@Value("${naming-strategy-apply-on-string-with-substring:''}")
	private String namingStrategyApplyOn;

	@Override
	public Identifier toPhysicalColumnName(final Identifier identifier, final JdbcEnvironment jdbcEnv) {
		return addPrefix(super.toPhysicalColumnName(identifier, jdbcEnv));
	}

	@Override
	public Identifier toPhysicalTableName(final Identifier identifier, final JdbcEnvironment jdbcEnv) {
		return addPrefix(super.toPhysicalColumnName(identifier, jdbcEnv));
	}

	private Identifier addPrefix(final Identifier identifier) {
		return (identifier != null && identifier.getText().matches("(.*)" + namingStrategyApplyOn + "(.*)"))
				? Identifier.toIdentifier(namingStrategyPrefix + identifier.getText())
				: identifier;
	}

}