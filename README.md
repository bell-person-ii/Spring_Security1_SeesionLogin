# 세션 기반 스프링 스큐리티 로그인 기본 설정예시

---

로그인 전 메인(/)
<img width="1512" alt="image" src="https://github.com/bell-person-ii/Spring_Security1_SeesionLogin/assets/76873740/efeb5048-4c68-492c-978b-aa3a84c37e81">

---

가입 (/join) : 해당 예시의 경우 기본적으로 admin 권한으로 가입 되도록 설정함
```
    public User toUserEntity(){

        final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        return User.builder()
                .username(username)
                .password(bCryptPasswordEncoder.encode(password))
                .role("ROLE_ADMIN")
                .build();
    }

```

<img width="1512" alt="image" src="https://github.com/bell-person-ii/Spring_Security1_SeesionLogin/assets/76873740/ac56669f-5d87-40a6-850d-27017d700857">

---

로그인(/login)
<img width="1512" alt="image" src="https://github.com/bell-person-ii/Spring_Security1_SeesionLogin/assets/76873740/cfed7cc1-6689-448b-bc01-2c8b165173fa">

---
로그인 후 메인(/)
<img width="1512" alt="image" src="https://github.com/bell-person-ii/Spring_Security1_SeesionLogin/assets/76873740/b6544166-673d-47b8-9d2d-7b45974a7ef8">

admin 페이지 (/admin)
<img width="1512" alt="image" src="https://github.com/bell-person-ii/Spring_Security1_SeesionLogin/assets/76873740/d8dd3737-1877-4175-893d-e5ee1ca785d1">

로그아웃(/logout)
