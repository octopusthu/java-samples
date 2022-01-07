package com.octopusthu.dev.security.jwt;

import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.jwk.source.RemoteJWKSet;
import com.nimbusds.jose.proc.JWKSecurityContext;
import com.nimbusds.jose.proc.JWSAlgorithmFamilyJWSKeySelector;
import com.nimbusds.jose.proc.JWSKeySelector;
import com.nimbusds.jwt.JWT;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.JWTParser;
import com.nimbusds.jwt.SignedJWT;
import com.nimbusds.jwt.proc.DefaultJWTProcessor;
import java.net.URL;

/**
 * JWT decoding samples
 *
 * @author Figo ZHANG
 */
public class JwtDecodingSamples {
    private static final String SAMPLE_ID_TOKEN =
            "eyJraWQiOiI3OTI2NmVjYjVlN2I0OTBiYmFiZmM2ZjljMGEzNzU2OCIsInR5cCI6IkpXVCIsImFsZyI6IlJTMjU2In0.eyJzdWIiOiIxMmY5NzZlOC1hNWQ2LTQ2ODAtOWU2Yy1iZjkyMmQ2YzE2YjQiLCJhdWQiOiJaV0prTnpnd04yWmpNMkUzTkRVM1ptSTFNRFZqTldOaU5HWTJOelk1TmpBIiwiYXpwIjoiWldKa056Z3dOMlpqTTJFM05EVTNabUkxTURWak5XTmlOR1kyTnpZNU5qQSIsImlzcyI6Imh0dHBzOlwvXC9zYW1wbGUucG9ydGFsLnRlbmNlbnRjaWFtLmNvbSIsImV4cCI6MTY0MTU2NDU3MSwidXNlck5hbWUiOiJmaWdvemhhbmciLCJpYXQiOjE2NDE1NjI3NzEsImp0aSI6ImE5MzViOWI3LTgzZTgtNDlmNi1iZjg0LTVjYmE3ZjBkOWZiOCJ9.M_Ebl900QENH-Y45hbCHjbIg2iDyxlemc_jY_qeZrYG0la5CRakqR_yK3-WJYUXOqKBAamAR-fUa_lDe14Z_xJp6RT5aosRxw9wIQilv0Ws08D57CMs-aMDk1BNXopzJA4_R_XzG1tk-w9Dmz_6XT8NRlk0sA1SDQNPmE1jv2v98a4Z9IKpzmV9PFLj6yGvjrk6VoVNVNMDJ-YUCX0LA3V1WgIuHxu-taxwmvgNrgsWt7FAKH8_IoGLdoLPZquk_BkQTxwp00b5oxH2XNH0PEFridVQDzJqMgyOiiAkbcDY7XglwP3V42PQtDCKRh9WSTOUxkfJqSaphn7CAP-k8EQ";

    public static void main(String[] args) throws Exception {
        JwtDecodingSamples.decodeJwtWithNimbus(SAMPLE_ID_TOKEN);
    }

    public static void decodeJwtWithNimbus(String idToken) throws Exception {
        URL jwkSetURL = new URL("https://sample.portal.tencentciam.com/oauth2/jwks");
        JWKSource<JWKSecurityContext> jwkSource = new RemoteJWKSet<>(jwkSetURL);
        JWSKeySelector<JWKSecurityContext> selector =
                new JWSAlgorithmFamilyJWSKeySelector<>(JWSAlgorithm.Family.RSA, jwkSource);

        DefaultJWTProcessor<JWKSecurityContext> jwtProcessor = new DefaultJWTProcessor<>();
        jwtProcessor.setJWSKeySelector(selector);

        JWT jwt = JWTParser.parse(idToken);
        if (jwt instanceof SignedJWT) {
            JWTClaimsSet jwtClaimsSet = jwtProcessor.process((SignedJWT) jwt, null);
            System.out.println("Decoded ID Token is: " + jwtClaimsSet);
        }
    }
}
