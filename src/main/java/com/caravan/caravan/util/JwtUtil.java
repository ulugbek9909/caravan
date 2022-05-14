package com.caravan.caravan.util;

import com.caravan.caravan.dto.ProfileJwtDTO;
import com.caravan.caravan.enums.ProfileRole;
import com.caravan.caravan.exceptions.AppBadRequestException;
import com.caravan.caravan.exceptions.AppForbiddenException;
import com.caravan.caravan.exceptions.TokenNotValidException;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Slf4j
public class JwtUtil {
    private final static String secretKey = "caravan";

    public static String encode(Long id, ProfileRole role) {
        return doEncode(id, null,  60);
    }

    public static String encode(Long id) {
        return doEncode(id, null,  3);
    }

    public static String doEncode(Long id, ProfileRole role, long minute) {
        JwtBuilder jwtBuilder = Jwts.builder();
        jwtBuilder.setSubject(String.valueOf(id));
        jwtBuilder.setIssuedAt(new Date());
        jwtBuilder.signWith(SignatureAlgorithm.HS256, secretKey);
        jwtBuilder.setExpiration(new Date(System.currentTimeMillis() + (minute * 60 * 1000)));
        jwtBuilder.setIssuer("mazgi production");

        if (role != null) {
            jwtBuilder.claim("role", role);
        }

        return jwtBuilder.compact();
    }

    public static ProfileJwtDTO decode(String jwt) {
        JwtParser jwtParser = Jwts.parser();

        jwtParser.setSigningKey(secretKey);
        Jws jws = jwtParser.parseClaimsJws(jwt);

        Claims claims = (Claims) jws.getBody();
        Long id = Long.valueOf(claims.getSubject());
        String role = String.valueOf(claims.get("role"));

        return new ProfileJwtDTO(id, ProfileRole.valueOf(role));
    }

    public static Long decodeAndGetId(String jwt) {
        try {
            JwtParser jwtParser = Jwts.parser();

            jwtParser.setSigningKey(secretKey);
            Jws jws = jwtParser.parseClaimsJws(jwt);

            Claims claims = (Claims) jws.getBody();

            return Long.valueOf(claims.getSubject());
        } catch (JwtException e) {
            log.warn("JWT expired {}", jwt);
            throw new AppBadRequestException(e.getMessage());
        }
    }


    public static Long getIdFromHeader(HttpServletRequest request, ProfileRole... requiredRoles) {
        try {
            ProfileJwtDTO dto = (ProfileJwtDTO) request.getAttribute("profileJwtDTO");
            if (requiredRoles == null || requiredRoles.length == 0) {
                return dto.getId();
            }
            for (ProfileRole role : requiredRoles) {
                if (role.equals(dto.getRole())) {
                    return dto.getId();
                }
            }
        } catch (RuntimeException e) {
            log.warn("Not Authorized");
            throw new TokenNotValidException("Not Authorized!");
        }
        log.warn("Not Access");
        throw new AppForbiddenException("Not Access!");
    }


    public static ProfileJwtDTO getProfileFromHeader(HttpServletRequest request, ProfileRole... requiredRoles) {
        try {
            ProfileJwtDTO dto = (ProfileJwtDTO) request.getAttribute("profileJwtDTO");
            if (requiredRoles == null || requiredRoles.length == 0) {
                return dto;
            }
            for (ProfileRole role : requiredRoles) {
                if (role.equals(dto.getRole())) {
                    return dto;
                }
            }
        } catch (RuntimeException e) {
            log.warn("Not Authorized");
            throw new TokenNotValidException("Not Authorized!");
        }
        log.warn("Not Access");
        throw new AppForbiddenException("Not Access!");

    }
}
