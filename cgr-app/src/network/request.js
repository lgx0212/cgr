import axios from 'axios'

export function request(config) {
  // 创建axios实例
  const instance = axios.create({
    baseURL: 'http://localhost:8888/cgr',
    timeout: 5000
  })
  // axios拦截器
  instance.interceptors.request.use(config => {
    // console.log(config);
    return config
  }, error => {
    // console.log(error);
  })

  instance.interceptors.response.use(res=>{
    // console.log(res);
    return res.data
  },error => {
    // console.log(error);
  })
  // 发送网络请求
  return instance(config)

}
