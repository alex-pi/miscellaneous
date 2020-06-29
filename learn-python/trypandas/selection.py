import numpy as np
import pandas as pd

sep = "\n *** {}: \n"
s = pd.Series([1, 3, 5, np.nan, 6, 8])
dates = pd.date_range('20130101', periods=6)
df = pd.DataFrame(np.random.randn(6, 5), index=dates, columns=list('ABCDE'))

print(sep.format('Selecting a single column, which yields a Series, equivalent to df.A'))
print(df.A)

#print(sep.format(''))
print(sep.format('Selecting via [], which slices the rows'))
print(df[0:3])
print(df['20130102':'20130104'])