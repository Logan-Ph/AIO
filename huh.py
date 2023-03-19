import multiprocessing
import time

def foo(n):
    for i in range(10000 * n):
        print(i)
        # time.sleep(1)

if __name__ == '__main__':
    # Start foo as a process
    p = multiprocessing.Process(target=foo , args=(10,))
    p.start()

    # Wait 10 seconds for foo
    time.sleep(2)

    # Terminate foo
    p.terminate()

    # Cleanup
    p.join()