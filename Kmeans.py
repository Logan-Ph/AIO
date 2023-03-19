import pygame
from random import randint
from sklearn.cluster import KMeans
import math

def distance(p1,p2):
	return math.sqrt((p1[0]-p2[0])*(p1[0]-p2[0]) + (p1[1]-p2[1])*(p1[1]-p2[1]))

pygame .init()

screen = pygame.display.set_mode((1200, 700))

pygame.display.set_caption("kmeans visualization")

running = True

clock = pygame.time.Clock()

BACKGROUND = (214,214,214)
BLACK = (0,0,0)
BACKGROUND_PANEL = (249,255,230)
WHITE = (255,255,255)

RED =  (255,0,0)
GREEN = (0,255,0)
BLUE = (0,0,255)
YELLOW = (147,153,35)
PURPLE = (255,0,255)
SKY = (0,255,255)
ORANGE = (255,125,25)
GRAPE = (100,25,125)
GRASS = (55,155,65)

COLORS = [RED,GREEN,BLUE,YELLOW,PURPLE,PURPLE,SKY,ORANGE,GRAPE,GRASS]

font = pygame.font.SysFont('sans', 40)
text_plus = font.render('+', True, WHITE)
text_minus = font.render('-', True, WHITE)
text_run = font.render('Run', True, WHITE)
text_random = font.render('Random', True, WHITE)
text_reset = font.render('Reset', True, WHITE)
text_algorithm = font.render('Algorithm', True, WHITE)

font_small = pygame.font.SysFont('sans', 20)


text_plus_rect = text_plus.get_rect(center=((850+900)/2,72.5))
text_minus_rect = text_minus.get_rect(center=((950+1000)/2,72.5))
text_run_rect = text_run.get_rect(center=((850+850+150)/2,(150+200)/2))
text_random_rect = text_random.get_rect(center=((850+850+150)/2,(250+250+50)/2))
text_algorithm_rect = text_algorithm.get_rect(center=((850+850+150)/2,(450+450+50)/2))
text_reset_rect = text_reset.get_rect(center=((850+850+150)/2,(550+550+50)/2))



K = int(0)
points = []
clusters = []
labels = [] 

while running:
	clock.tick(60)
	screen.fill(BACKGROUND)

	mouse_x,mouse_y = pygame.mouse.get_pos()

	#Draw interface
	#Draw panel 
	pygame.draw.rect(screen, BLACK, (50,50,700,500))
	pygame.draw.rect(screen, BACKGROUND_PANEL, (55,55,690,490))

	# K button +
	pygame.draw.rect(screen, BLACK, (850,50,50,50))
	screen.blit(text_plus,text_plus_rect)
	
	# K button -
	pygame.draw.rect(screen, BLACK, (950,50,50,50))
	screen.blit(text_minus,text_minus_rect)
	
	# K value 
	text_k = font.render('K = '+ str(K), True, BLACK)
	screen.blit(text_k,(1050,50))

	# run 
	pygame.draw.rect(screen, BLACK, (850,150,150,50))
	screen.blit(text_run,text_run_rect)
	
	# random button 
	pygame.draw.rect(screen, BLACK, (850,250,150,50))
	screen.blit(text_random,text_random_rect)

	# algorithm
	pygame.draw.rect(screen, BLACK, (850,450,150,50))
	screen.blit(text_algorithm,text_algorithm_rect)

	# reset
	pygame.draw.rect(screen, BLACK, (850,550,150,50))
	screen.blit(text_reset,text_reset_rect)	

	# Draw mouse position when mouse is in panel 
	if 50<mouse_x<750 and 50<mouse_y<550:
		text_mouse = font_small.render("(" + str(mouse_x - 50) + "," + str(mouse_y-50) + ")",True, BLACK)
		screen.blit(text_mouse, (mouse_x,mouse_y))


	for event in pygame.event.get():
		if event.type == pygame.MOUSEBUTTONUP:
			if event.button == 1:
				# create point on panel 
				if 50<mouse_x<750 and 50<mouse_y<550:
					labels = []
					point = [mouse_x-50,mouse_y-50]
					points.append(point)

				# Change K button+
				if (850<mouse_x<900) and (50<mouse_y<100):
					if K <9 :
						K +=1
						print("Press K+")
				
				# Change K button 
				if (950<mouse_x<1000) and (50<mouse_y<100):	
					if K>0:
						K -=1				
					print("Press K-")

				# Run 
				if (850<mouse_x<1000) and (150<mouse_y<200):
					if K > 0 and len(clusters) > 0 :
						labels = []
						for p in points:
							distances_to_clusters = []
							for c in clusters:
								dis = distance(p,c)
								distances_to_clusters.append(dis)

							min_distance = min(distances_to_clusters)
							label = distances_to_clusters.index(min_distance)
							labels.append(label)

						for i in range(K):
							sum_x = 0
							sum_y = 0
							count = 0
							for j in range(len(points)):
								if labels[j] == i:
									sum_x += points[j][0]
									sum_y += points[j][1]
									count += 1 
								if count != 0:
									new_clusters_x = sum_x/count
									new_clusters_y = sum_y/count
									clusters[i] = [new_clusters_x,new_clusters_y]
			 
						print("Press Run")

				# random
				if (850<mouse_x<850+150) and (250<mouse_y<300):
					clusters = []
					labels = []
					for i in range(K):
						random_point = [randint(0,700), randint(0,500)]
						clusters.append(random_point)
					print("Press Random")

				# reset
				if (850<mouse_x<850+150) and (550<mouse_y<550+50):	
					labels = []
					points = []
					clusters = []
					error = 0
					K = 0
					text_error = font.render("Error = " + str(int(error)), True, BLACK)
					screen.blit(text_error, (850,350))
					print("Press reset")

				# algorithm
				if (850<mouse_x<850+150) and (450<mouse_y<500):
					try:
						kmeans = KMeans(n_clusters=K).fit(points)
						labels = kmeans.predict(points)
						clusters = kmeans.cluster_centers_
					except:
						print("Press algorithm")	

		if event.type == pygame.QUIT:
			running = False
	# draw cluster
	for i in range(len(clusters)):
		pygame.draw.circle(screen, COLORS[i], (int(clusters[i][0]) + 50, int(clusters[i][1]) + 50), 5)

	# draw points 
	for i in range(len(points)):
		pygame.draw.circle(screen, BLACK, (points[i][0] + 50,points[i][1] + 50), 6)

		if labels == []:
			pygame.draw.circle(screen, WHITE, (points[i][0] + 50,points[i][1] + 50), 5)
		else:
			pygame.draw.circle(screen, COLORS[labels[i]], (points[i][0] + 50,points[i][1] + 50), 5)

	error = 0
	if clusters != [] and labels != []:
		for i in range(len(points)):
			error += distance(points[i], clusters[labels[i]])

	text_error = font.render("Error = " + str(int(error)), True, BLACK)
	screen.blit(text_error, (850,350))
	pygame.display.flip()

pygame.quit()