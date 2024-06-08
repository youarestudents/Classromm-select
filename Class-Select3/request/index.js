// util/http.js

export function get(url) {
  return new Promise((resolve, reject) => {
    uni.request({
      url: url,
      method: 'GET',
      // data: params,
      success: res => {
        resolve(res.data);
      },
      fail: err => {
        reject(err);
      }
    });
  });
}
export function post(url,data = {}) {
  return new Promise((resolve, reject) => {
    uni.request({
      url: url,
      method: 'POST',
       data: data,
      success: res => {
        resolve(res.data);
      },
      fail: err => {
        reject(err);
      }
    });
  });
}