import numpy as np
import pandas as pd
import matplotlib.pyplot as plt
plt.rcParams['font.sans-serif'] = ['SimHei'] # 用来正常显示中文标签SimHei
plt.rcParams['axes.unicode_minus'] = False # 用来正常显示负号

# 模拟一周的废水流量数据
np.random.seed(0)
hours = np.arange(1, 169)  # 一周有7天，每天24小时，总共168小时
flow_rate = np.random.randint(10, 50, 168)  # 随机生成每小时的废水流量数据（示例数据）

# 创建一个Pandas DataFrame来存储数据
data = pd.DataFrame({'Hour': hours, 'FlowRate': flow_rate})

# 创建折线图
plt.figure(figsize=(10, 6))
plt.plot(data['Hour'], data['FlowRate'], marker='o', linestyle='-')
plt.title('废水流量变化趋势')
plt.xlabel('小时')
plt.ylabel('废水流量（立方米/小时）')
plt.grid(True)

# 显示图表
plt.show()
