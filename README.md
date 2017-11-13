# vfiis-wrapper
동네 예보 조회 서비스 wrapper library  
개발 중에 있으며 현재는 raw data 를 뽑아내는 수준밖에 되지 않는다.

## Getting Started
1. repository, dependency 추가

__Maven__
````xml
<repository>
    <id>jcenter</id>
    <url>https://jcenter.bintray.com</url>
</repository>

<dependency>
  <groupId>com.github.galcyurio</groupId>
  <artifactId>vfiis-wrapper</artifactId>
  <version>0.1.0</version>
</dependency>
````

__Gradle__
````gradle
repositories{
  jcenter()
}
// ....

compile 'com.github.galcyurio:vfiis-wrapper:0.1.0'
````

2. RawVfiisClient 를 통해 raw 데이터 출력
````java
public class RawVfiisSample {
    public static void main(String[] args) {
        RawVfiisClient.initialize(new Configuration(Tester.serviceKey));

        Calendar calendar = Calendar.getInstance();
        calendar.set(2017, Calendar.NOVEMBER, 12, 2, 0, 0);
        RawVfiisClient.getInstance().fetchForecastGrib(new ForecastRequest(calendar.getTime(), 60, 127)).enqueue(new Callback<Map<String, Object>>() {
            @Override
            public void onResponse(Call<Map<String, Object>> call, Response<Map<String, Object>> response) {
                if(response.isSuccessful()) {
                    System.out.println(response.body());
                }
            }

            @Override
            public void onFailure(Call<Map<String, Object>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
````

## License
````
Copyright 2017 galcyurio

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
````
