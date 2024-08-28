package cuber.post.app.identity.service;

import cuber.post.app.sdk.service.RandomService;
import jakarta.annotation.Resource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * DATE: 2024/8/28
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
@Service
public class PasswordService extends BCryptPasswordEncoder {

    private static final char[] CHAR_DICT = new char[] {
        'a', 'b', 'c', 'd', 'e', 'f',
        'g', 'h', 'j', 'k', 'l', 'm',
        'n', 'p', 'q', 'r', 's', 't',
        'u', 'v', 'w', 'x', 'y', 'z',
        'A', 'B', 'C', 'D', 'E', 'F',
        'G', 'H', 'J', 'K', 'L', 'M',
        'N', 'P', 'Q', 'R', 'S', 'T',
        'U', 'V', 'W', 'X', 'Y', 'Z',
        '2', '3', '4', '5', '6', '7',
        '8', '9', '+', '@', '$', '%'
    };
    private static final int CHAR_DICT_SIZE = CHAR_DICT.length;

    private static final int MIN_PASSWORD_LENGTH = 8;
    private static final int MAX_PASSWORD_LENGTH = 16;

    @Resource
    private RandomService randomService;

    public String randomPassword() {
        int len = randomService.randomInt(MIN_PASSWORD_LENGTH, MAX_PASSWORD_LENGTH);
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            int index = randomService.randomInt(0, CHAR_DICT_SIZE - 1);
            sb.append(CHAR_DICT[index]);
        }
        return sb.toString();
    }
}
