Memory
├── CRUD
├── 标题搜索
├── favorite
├── discoverDate
├── type
├── Tag
│   ├── 用户自定义
│   ├── 自动复用已有 Tag
│   └── 自动创建新 Tag
├── Memory ↔ Tag 多对多
├── Update 时同步 Tag 关系
├── 根据 Tag 筛选 Memory
├── 计算每个Tag标记几条Memory
└── 根据好几个memory的属性筛选Memory


对应 API：
POST   /api/memories
GET    /api/memories
GET    /api/memories/{id}
PUT    /api/memories/{id}
DELETE /api/memories/{id}

GET    /api/memories/search?keyword=xxx
GET    /api/memories/searchbytag?name=xxx
GET    /api/memories/filter?type=xxx&favorite=xxx

GET    /api/tags
GET    /api/tags/{tagId}/count