package com.service.register.service;

import org.hibernate.context.spi.CurrentTenantIdentifierResolver;

import java.util.Objects;

public class CurrentTenantIdentifierResolverImpl implements CurrentTenantIdentifierResolver {

    @Override
    public Object resolveCurrentTenantIdentifier() {
        String tenant = AppTenantContext.getCurrentTenant();
        System.out.println("Current tenant is " + tenant);
        return Objects.requireNonNullElse(tenant, "public");
    }

    @Override
    public boolean validateExistingCurrentSessions() {
        return true;
    }
}
