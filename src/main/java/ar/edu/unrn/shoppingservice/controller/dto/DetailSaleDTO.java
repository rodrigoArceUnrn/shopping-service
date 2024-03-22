package ar.edu.unrn.shoppingservice.controller.dto;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import lombok.Data;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class DetailSaleDTO {
    private List<ProductDTO> listProduct;
    private SaleDTO sale;

    public DetailSaleDTO(SaleDTO sale, List<ProductDTO> productList) {
        this.sale = sale;
        this.listProduct = productList;
    }

    public String toJsonString() {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                .create();
        return gson.toJson(this);
    }

    private static class LocalDateTimeAdapter extends TypeAdapter<LocalDateTime> {
        @Override
        public void write(JsonWriter out, LocalDateTime value) throws IOException {
            out.value(value.toString()); // O cualquier otro formato deseado
        }

        @Override
        public LocalDateTime read(JsonReader in) throws IOException {
            return LocalDateTime.parse(in.nextString()); // O cualquier otro formato deseado
        }
    }
}