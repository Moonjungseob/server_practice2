package com.busanit501.samplejsp501.todo.dao;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;

public enum MenuUtil {
    INSTANCE;
    private HikariDataSource dataSource;

    //생성자
    MenuUtil(){
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("org.mariadb.jdbc.Driver");
        config.setJdbcUrl("jdbc:mariadb://localhost:3306/webdb");
        config.setUsername("webuser");
        config.setPassword("webuser");

        //옵션.
        //기본값으로 사용하고, 나중에, 배포시, 디비 서버만 단독으로 사용할 때,
        //그 때, 메모리 양을 정함. 참고로, 전체 메모리의 70~80%, 디비서버에 모두 할당

        //sql 전달 시 PreparedStatement 기법 쓰겠다. 동적으로 sql문을 전달하겠다 -> ? 와일드카드
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        //선언한 인스턴스 여기서 초기화
        dataSource = new HikariDataSource(config);
    }

    // Connection 리턴 해주는 , 메서드, 디비 연결하는 도구 .
    public Connection getConnection() throws Exception{
        return dataSource.getConnection();
    }
    //사용법
    //Connection con = ConnectionUtil.INSTANCE.getConnection();
}