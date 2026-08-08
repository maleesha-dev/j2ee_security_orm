package lk.novasphere.security;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.security.enterprise.credential.Credential;
import jakarta.security.enterprise.credential.UsernamePasswordCredential;
import jakarta.security.enterprise.identitystore.CredentialValidationResult;
import jakarta.security.enterprise.identitystore.IdentityStore;
import lk.novasphere.service.LoginService;

import java.util.Set;

@ApplicationScoped
public class AppIdentityStore implements IdentityStore {

//    private static final Map<String, User> USERS = new HashMap<>();
//
//    static {
//        USERS.put("maleesha", new User("maleesha", "0000", Set.of("ADMIN", "USER")));
//        USERS.put("hirushan", new User("hirushan", "1111", Set.of("USER")));
//    }

    @Inject
    private LoginService loginService;

    @Override
    public CredentialValidationResult validate(Credential credential) {
        System.out.println("AppIdentityStore: validate");

        if (credential instanceof UsernamePasswordCredential) {
            UsernamePasswordCredential upc = (UsernamePasswordCredential) credential;

//            User user = USERS.get(upc.getCaller());
//            if (user != null && user.getPassword().equals(upc.getPasswordAsString())) {
//                return new CredentialValidationResult(upc.getCaller(), user.getRoles());
//            }

            if (loginService.validate(upc.getCaller(), upc.getPasswordAsString())) {
                Set<String> roles = loginService.getRoles(upc.getCaller());

                return new CredentialValidationResult(upc.getCaller(), roles);
            }

        }

        return CredentialValidationResult.INVALID_RESULT;
    }
}
