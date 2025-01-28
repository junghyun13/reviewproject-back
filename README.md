# reviewproject-back
리뷰시스템프로젝트 백엔드 테스트
기본 키워드 검색 
SELECT id, name, keywords
FROM restaurants
WHERE name LIKE '%가성비%'
   OR keywords LIKE '%가성비%';

위치기반으로 반경2km안에 있는 식당찾기 
SELECT id, name, latitude, longitude
FROM restaurants
WHERE ST_Distance_Sphere(Point(longitude, latitude), Point(126.9780, 37.5665)) <= 2000;


SELECT * from restaurants;
CREATE database simpleDb_test;
use simpleDb_test;

더미데이터 이용
INSERT INTO restaurants (email, name, rating, review, category, latitude, longitude, keywords, reviewer) VALUES
('user1@example.com', '한식당1', 4.5, '아주 맛있어요!', '한식', 37.5665, 126.9780, '깨끗함,서비스굿', '리뷰어1'),
('user2@example.com', '양식당1', 3.8, '가성비 좋습니다.', '양식', 37.5700, 126.9850, '가성비,분위기좋음', '리뷰어2'),
('user3@example.com', '한식당2', 4.7, '정말 훌륭해요!', '한식', 37.5650, 126.9900, '맛있음,친절함', '리뷰어3'),
('user4@example.com', '양식당2', 4.2, '가족들과 즐기기 좋습니다.', '양식', 37.5670, 126.9750, '조용함,분위기좋음', '리뷰어4'),
('user5@example.com', '한식당3', 3.9, '전통적인 맛!', '한식', 37.5640, 126.9730, '전통적,가성비', '리뷰어5'),
('user6@example.com', '양식당3', 4.6, '로맨틱한 분위기!', '양식', 37.5630, 126.9720, '분위기좋음,서비스굿', '리뷰어6'),
('user7@example.com', '한식당4', 4.1, '매우 친절합니다.', '한식', 37.5620, 126.9740, '친절함,서비스굿', '리뷰어7'),
('user8@example.com', '양식당4', 4.4, '요리가 신선해요.', '양식', 37.5610, 126.9760, '신선함,맛있음', '리뷰어8'),
('user9@example.com', '한식당5', 4.0, '집밥 같은 느낌이에요.', '한식', 37.5600, 126.9770, '전통적,편안함', '리뷰어9'),
('user10@example.com', '양식당5', 3.7, '조금 비싸요.', '양식', 37.5590, 126.9790, '비쌈,분위기좋음', '리뷰어10'),
-- (20개 더 추가) ...
('user29@example.com', '한식당15', 4.3, '전체적으로 만족스러워요.', '한식', 37.5615, 126.9810, '가성비,친절함', '리뷰어29'),
('user30@example.com', '양식당15', 4.8, '완벽한 저녁식사!', '양식', 37.5625, 126.9820, '분위기좋음,서비스굿', '리뷰어30');
