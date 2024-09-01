create table short_url (
    id UUID NOT NULL DEFAULT gen_random_uuid(),
    expiry timestamptz default CURRENT_TIMESTAMP + interval '1 year',
    created_at timestamp default CURRENT_TIMESTAMP,
    alias varchar(7) UNIQUE NOT NULL,
    distributed_id BIGINT UNIQUE NOT NULL,
    long_url STRING NOT NULL,
    PRIMARY KEY (id));