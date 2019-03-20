package uk.gov.hmcts.reform.cmc.submit.ccd.mapper;

public interface Mapper<K, V> {

    K to(V v);

    V from(K k);
}