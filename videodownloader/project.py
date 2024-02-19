import sys, re
from pytube import YouTube
from pyfiglet import Figlet
figlet = Figlet()
figlet.getFonts()

def main():
    try:
        link = valid(input("Enter video link: "))
        yt = YouTube(link)
        downloader(yt)
    except:
        print("Some error occured try again later ")

def valid(link):
    if not re.search(r"^(http([s]|))?(:\/\/)?(www.)?youtube.com\/[a-zA-Z0-9]..+$", link):
        sys.exit("Invalid link try other link ")
    else:
        return link

def downloader(yt):
    print("\nTitle: ",yt.title)
    results=yt.streams.filter(progressive=True)
    results1=str(results)
    a=available_reso(results1)
    results=yt.streams.get_by_itag(resolution(a))
    print("Downloading please wait a moment...")
    results.download()
    print("Download completed!!")

def available_reso(results1):
    list=re.findall(r'itag="(..)"',results1)
    return list

def nos():
    x=int(input("Enter nos. of videos "))
    return x

def resolution(found_resolutions):
    supported_resolution = { "17#": "240p", "18": "360p","22": "720p" }
    print("\nAvailable resolutions")
    for _ in found_resolutions:
        if _ in supported_resolution:
            print(f"  {supported_resolution[_]}")
    download_reso = int(input("\nEnter resolution of video: "))
    if download_reso == 240:
        return 17
    elif download_reso == 360:
        return 18
    elif download_reso == 720:
        return 22
    else:
        sys.exit("Entered a invalid resolution")

if __name__ == "__main__":
    text = "Video Downloader"
    print(figlet.renderText(text))
    n=nos()
    continu=1
    for i in range(n):
        print()
        print("For, number ",i+1," video: ")
        main()
        continu=int(input("Enter 0 to stop and 1 to continue: "))
        if continu==0:
            break
    text = "Thank you!!"
    print(figlet.renderText(text))