# hashCode


HashTable은 hashCode() 메소드를 사용하여 주어진 키에 대한 해시 값을 계산하고, 내부적으로 이 값을 사용하기 때문에 데이터를 접근할 때 효율적이다.

### hashCode() 작동 방식

- 해시코드는 알고리즘에 의해 생성된 정수 값이다.

해시코드 규약

- equals 비교에 사용되는 정보가 변경되지 않았다면, 애플리케이션이 실행되는 동안 그 객체의 hashCode 메소드 또한 일관되게 같은 값을 반환한다. (애플리케이션을 다시 실행하면 이 값이 달라질 수 있다.)
- equals(Object)가 두 객체를 같다고 판단했다면, 두 객체는 같은 hash 값을 반환한다.
- equals(Object)가 두 객체를 다르다고 판단했더라도 hashCode가 같을 수 있다. 단 다른 객체에 대해서 다른 값을 반환해야 해시테이블의 성능이 좋아진다.

- Object.hashCode()는 객체의 주소값으로 hash값을 생성하기 때문에 같은 값을 가진 객체라도 다른 hash 값을 리턴한다.

```jsx
static class User {
    String email;
    int id;

    public User(String email, int id) {
        this.email = email;
        this.id = id;
    }
}

User user1 = new User("abc",1);
User user2 = new User("abc",1);

System.out.println(user1.equals(user2)); // ?

// 정답 : false
// 이유 : equals는 user1의 hashCode()와 user2의 hashCode()의 반환 값을 비교하는데
// Object.hashCode()는 각 객체의 주소 값을 hash값으로 변환하는데
// user1과 user2의 주소 값은 다르기 때문
```

- 그렇다면 equals만 오버라이딩 해서 커스텀 하면 될까?
    - equals는 작동하지만 HashMap, HashTable,

```jsx
static class User {
      String email;
      int id;

      public User(String email, int id) {
          this.email = email;
          this.id = id;
      }

      @Override
      public boolean equals(Object obj) {
          if(this == obj) return true;
          if(obj == null || getClass() != obj.getClass()) return false;
          User user = (User) obj;
          return this.email.equals(user.email) &&
                      this.id == user.id;
      }
}

User user1 = new User("abc",1);
User user2 = new User("abc",1);

System.out.println(user1.equals(user2)); // ?

// 정답 : true
// 이유 : Object.equals가 아닌 User.equals를 사용하게 되었으니 당연히 된다.
// 문제점 : HashMap, TreeMap, HashTable같은 경우 key의 hashCode() 메서드를 통해 구분
// 현재의 User 객체를 HashMap에 넣을 때 같은 값을 가지지만 hashCode가 다른 객체를 넣는다면
// 다른 객체로 보게 됨 == 성능 저하
```

- 반대로 hashCode()만 오버라이딩 한다면?
    - user.equals(user2)는 Object.equals를 사용하게 되는데 이는 단순히 주소 값의 비교이기 때문에 같은 값을 가지고 있더라도 다른 객체라 표현된다.
- 즉 hashCode와 equals를 같이 오버라이딩 해줘야 한다.
