package scalerlearningapi.productapi.security;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.oauth2.jwt.Jwt;

public class CustomJwtAuthenticationConverter implements Converter<Jwt, AbstractAuthenticationToken>
{
    private final JwtGrantedAuthoritiesConverter grantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();
    private static Collection< ? extends GrantedAuthority > extractResourceRoles(final Jwt jwt)
    {
        List<String> roles =  jwt.getClaim("roles");
        List<GrantedAuthority> grantedAuthorities= new ArrayList<>();

        for(String role: roles){
            grantedAuthorities.add(new SimpleGrantedAuthority(role));

        }
        return  grantedAuthorities;


    }

    @Override

    public AbstractAuthenticationToken convert(Jwt source) {
        Collection<GrantedAuthority> authorities =
                Stream.concat(grantedAuthoritiesConverter.convert(source).stream(),
                        extractResourceRoles(source).stream())
                        .collect(Collectors.toSet());
        return new JwtAuthenticationToken(source,authorities);
    }
//    private static Collection<? extends GrantedAuthority> extractResourceRoles(final Jwt jwt, final String resourceId)
//    {
//        Map<String, Object> resourceAccess = jwt.getClaim("resource_access");
//        Map<String, Object> resource;
//        Collection<String> resourceRoles;
//        if (resourceAccess != null && (resource = (Map<String, Object>) resourceAccess.get(resourceId)) != null &&
//                (resourceRoles = (Collection<String>) resource.get("roles")) != null)
//            return resourceRoles.stream()
//                    .map(x -> new SimpleGrantedAuthority("ROLE_" + x))
//                    .collect(Collectors.toSet());
//        return Collections.emptySet();
//    }
//
//    private final JwtGrantedAuthoritiesConverter defaultGrantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();
//
//    private final String resourceId;
//
//    public CustomJwtAuthenticationConverter(String resourceId)
//    {
//        this.resourceId = resourceId;
//    }
//
//    @Override
//    public AbstractAuthenticationToken convert(final Jwt source)
//    {
//        Collection<GrantedAuthority> authorities = Stream.concat(defaultGrantedAuthoritiesConverter.convert(source)
//                                .stream(),
//                        extractResourceRoles(source, resourceId).stream())
//                .collect(Collectors.toSet());
//        return new JwtAuthenticationToken(source, authorities);
//    }
}
