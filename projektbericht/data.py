import polars as pl

df_org = pl.read_csv("data/social_media.csv")
print("---------------------------")
print(f"Original Shape: {df_org.shape}")
print("---------------------------")

def print_columns(df: pl.DataFrame) -> None:
    counter = 0
    for column in df.columns:
        print(column)
        counter += 1
        
    print("---------------------------")
    print(f"Count: {counter}")
    print("---------------------------")

print_columns(df_org)

print(df_org['Profession'].unique())

df = df_org.select([
    "UserID",
    "Gender",
    "Age",
    "Income",
    "Profession",
    "Demographics",
    "Platform",
    "Location",
    "Addiction Level",
    "Self Control"
])
print_columns(df)

corrections = {'Barzil':'Brazil', 'United States':'US', 'Labor/Worker':'Worker', 'Waiting staff':'Server', 'driver':'Driver'}
df = df.with_columns(
    pl.col('Location').replace(corrections).alias('Location'),
    pl.col('Profession').replace(corrections).alias('Profession')
)

column_names = {
    'Addiction Level':'AddictionLevel',
    'Self Control':'SelfControl'
}

df = df.rename(column_names)

df = df.sample(n=20, with_replacement=False, seed=4)

print(df)

df.write_csv("data/social_media_sample.csv")