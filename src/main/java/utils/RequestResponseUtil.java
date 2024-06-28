package utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public class RequestResponseUtil {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    // 从HttpServletRequest中读取JSON数据并反序列化为指定类型的对象
    public static <T> T readJsonFromRequest(HttpServletRequest request, Class<T> clazz) throws IOException {
        request.setCharacterEncoding("UTF-8");
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = request.getReader()) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        }
        return objectMapper.readValue(sb.toString(), clazz);
    }

    // 将对象序列化为JSON字符串并写入HttpServletResponse
    public static <T> void writeJsonResponse(HttpServletResponse response, List<T> list) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        String json = objectMapper.writeValueAsString(list);
        response.getWriter().write(json);
    }
}
