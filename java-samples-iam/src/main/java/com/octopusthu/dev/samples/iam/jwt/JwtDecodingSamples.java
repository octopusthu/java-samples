package com.octopusthu.dev.samples.iam.jwt;

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
            "eyJraWQiOiJlMTVkOGZiN2RiNmQ0NTY1ODkyNmI1OGZlNDQyMTY2MiIsInR5cCI6IkpXVCIsImFsZyI6IlJTMjU2In0.eyJzdWIiOiIxMmY5NzZlOC1hNWQ2LTQ2ODAtOWU2Yy1iZjkyMmQ2YzE2YjQiLCJhdWQiOiJaV0prTnpnd04yWmpNMkUzTkRVM1ptSTFNRFZqTldOaU5HWTJOelk1TmpBIiwiYXpwIjoiWldKa056Z3dOMlpqTTJFM05EVTNabUkxTURWak5XTmlOR1kyTnpZNU5qQSIsImlzcyI6Imh0dHBzOlwvXC9zYW1wbGUucG9ydGFsLnRlbmNlbnRjaWFtLmNvbSIsImV4cCI6MTY0NjgzMTgwNCwidXNlck5hbWUiOiJmaWdvemhhbmciLCJpYXQiOjE2NDY4MzAwMDQsImp0aSI6ImM0NmRmYWQ3LWY3OTYtNGIxZi04MjVhLTE5YjViNWE1YzM0MiJ9.JB5gHztqBHgeHBZQneJZaDR1SQaKBKoYOX5-B-XUUrM-8AvoqXrRWVuSvkCMAt893UgMK5M6oogAkVIni7-LuvIDl6aOXHafGUaHr79sSCVfap2X0gvFsXM7ljGuwm358PD0Ot01J3P5t9M3m5L9Me9VONgnsXYZoNjnKcsHgKbhW_8iJq4pBQz7rBGbIUAy0Vb_izODZHU7BKnvXjOM63rcJhVgXoZDRuzDTMJh9eR7xzgSxTEnWamhEPZuZb3f6OIwNXA3rZh1V1aXiyZoNHuQs041LVS2cbyrCyfD_0Ipj5hs7kQ4AlIAWyhSVv3hilRsqzkLE9NtfK9MxEHnnA";

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
